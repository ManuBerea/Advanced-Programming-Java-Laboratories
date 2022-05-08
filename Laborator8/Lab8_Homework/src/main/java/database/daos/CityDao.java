package database.daos;

import database.DatabaseConnection;
import database.entities.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDao { //DAO = Data Access Object
    private final PreparedStatement getById;
    private final PreparedStatement insertValue;
    private final PreparedStatement getByName;

   public CityDao() throws SQLException {
       Connection conn = DatabaseConnection.getInstance().getConnection();
       //prepareStatement - compileza la nivel general o comanda sql care va urma sa fie executata cu anumiti parametrii
       getById = conn.prepareStatement("select * from cities where id = ?");
       insertValue = conn.prepareStatement("insert into cities values (?, ?, ?, ?, ?, ?)");
       getByName = conn.prepareStatement("select * from cities where name = ?");
   }

    public String findById(int id) throws SQLException {
        if (id < 1) {
            System.out.println("Invalid ID (must be over 0!)");
            return null;
        }

        getById.setInt(1, id); // 1 pt ca este primul "?"
        ResultSet result =  getById.executeQuery(); // rezultatul executiei comenzii sql pregatite

        City city = null;

        while (result.next()) { //trece prin toate randurile tabelei
            city =  new City();
            city.setId(result.getInt(1));
            city.setCountry(result.getString(2));
            city.setName(result.getString(3));
            city.setCapital(result.getInt(4));
            city.setLatitude(result.getDouble(5));
            city.setLongitude(result.getDouble(6));
        }
        assert city != null;
        return city.getName();
    }

    public int findByName(String name) throws SQLException {

        getByName.setString(1, name); // 1 pt ca este primul "?"
        ResultSet result =  getByName.executeQuery(); // rezultatul executiei comenzii sql pregatite

        City city = null;

        while (result.next()) { //
            city =  new City();
            city.setId(result.getInt(1));
            city.setCountry(result.getString(2));
            city.setName(result.getString(3));
            city.setCapital(result.getInt(4));
            city.setLatitude(result.getDouble(5));
            city.setLongitude(result.getDouble(6));
        }
        assert city != null;
        return city.getId();
    }

    public void insert(City city) throws SQLException {
        if (city == null) {
            System.out.println("Cannot insert a null actor!");
            return;
        }

        insertValue.setInt(1, city.getId());
        insertValue.setString(2, city.getCountry());
        insertValue.setString(3, city.getName());
        insertValue.setInt(4, city.getCapital());
        insertValue.setDouble(5, city.getLatitude());
        insertValue.setDouble(6, city.getLongitude());

        insertValue.execute();
    }
}
