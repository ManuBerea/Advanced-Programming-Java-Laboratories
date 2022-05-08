package database;

import database.daos.CityDao;
import database.daos.ContinentDao;
import database.daos.CountryDao;
import database.entities.City;
import database.entities.Continent;
import database.entities.Country;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DatabaseEditor {
    private CityDao cityDao;
    private CountryDao countryDao;
    private ContinentDao continentDao;

    public DatabaseEditor() {
        try {
        cityDao = new CityDao();
        countryDao = new CountryDao();
        continentDao = new ContinentDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddDataToDB() {
        try {
            Scanner scanner = new Scanner(System.in);

            //--------- find city by a specific criteria ---------:
            System.out.print("\nFind city by id:");
            int id = scanner.nextInt();
            System.out.println(findCityById(id));

            System.out.print("\nFind city by name:");
            String cityName = scanner.next();
            System.out.println(findCityByName(cityName));

            //--------- add a new city ---------:
            System.out.println("\nAdd a new city! ");

            City city = new City();
            city.setId(getNextId("cities"));

            System.out.println("Name of the city:");
            city.setName(scanner.next());

            System.out.println("Country it belongs:");
            city.setCountry(scanner.next());

            System.out.println("Is this city a capital? (1-yes / 0-no)");
            city.setCapital(scanner.nextInt());

            System.out.println("City latitude:");
            city.setLatitude(scanner.nextDouble());

            System.out.println("City longitude:");
            city.setLongitude(scanner.nextDouble());

            addCity(city);

            //--------- add a new country ---------:
            System.out.println("\nAdd a new country! ");

            Country country = new Country();
            country.setId(getNextId("countries"));

            System.out.println("Name of the country:");
            country.setName(scanner.next());

            System.out.println("Code of the country:");
            country.setCode(scanner.nextInt());

            System.out.println("Continent of the country:");
            country.setContinent(scanner.next());

            addCountry(country);

            //--------- add a new continent ---------:
            System.out.println("\nAdd a new continent! ");

            Continent continent = new Continent();
            continent.setId(getNextId("continents"));

            System.out.println("Name of the continent:");
            continent.setName(scanner.next());

            addContinent(continent);

            System.out.println("\nYou added all informations needed to the database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getNextId(String table) throws SQLException {
        PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement("select nvl(max(id), 0) + 1 from " + table); // nvl - 0 in loc de null
        ResultSet set = pstmt.executeQuery();
        set.next(); // Moves the cursor forward one row from its current position.
        return set.getInt(1);
    }

    public String findCityById(int id) throws SQLException {
        return cityDao.findById(id);
    }

    public int findCityByName(String name) throws SQLException {
        return cityDao.findByName(name);
    }

    public void addCity(City city) throws SQLException {
        cityDao.insert(city);
    }

    public void addCountry(Country country) throws SQLException {
        countryDao.insert(country);
    }

    public void addContinent(Continent continent) throws SQLException {
        continentDao.insert(continent);
    }

    public void addDataFromCSVFile(String path) throws SQLException, IOException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        conn.setAutoCommit(false);

        String sql = "INSERT INTO cities (id, country, name, capital, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        BufferedReader lineReader = new BufferedReader(new FileReader(path));
        String lineText = null;

        lineReader.readLine(); // skip header line

        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(",");
            String id = data[0];
            String country = data[1];
            String name = data[2];
            String capital = data[3];
            String latitude = data[4];
            String longitude = data[5];

            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.setString(2, country);
            pstmt.setString(3, name);
            pstmt.setInt(4, Integer.parseInt(capital));
            pstmt.setDouble(5, Double.parseDouble(latitude));
            pstmt.setDouble(6, Double.parseDouble(longitude));

            pstmt.addBatch();
            pstmt.executeBatch();
        }

        lineReader.close();

        // execute the remaining queries
        pstmt.executeBatch();
        conn.commit();
    }

    public void distanceBetweenCities(String city1, String city2) throws SQLException {
        double latDist = 0, longDist = 0, lat1 = 0, lat2 = 0, long1 = 0, long2 = 0;
        final int R = 6371; // Radious of the earth
        Connection conn = DatabaseConnection.getInstance().getConnection();

        try (Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery(
                     "select latitude , longitude  from cities where name ='" + city1 + "'");

             ) {

            while(result.next()) {
                lat1 = result.getDouble(1);
                long1 = result.getDouble(2);
            }

            ResultSet result2 = stmt.executeQuery(
                    "select latitude , longitude  from cities where name ='" + city2 + "'");

            while (result2.next()) {
                lat2 = result2.getDouble(1);
                long2 = result2.getDouble(2);
            }

            latDist = toRad(lat2-lat1);
            longDist = toRad(long2-long1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        double a = Math.sin(latDist / 2) * Math.sin(latDist / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(longDist / 2) * Math.sin(longDist / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = R * c;

        System.out.print(distance);
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

}


