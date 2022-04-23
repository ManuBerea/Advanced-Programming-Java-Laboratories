import compulsory.*;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania");
            countries.create("Ukraine");
            continents.create("Asia");
            continents.create("Europe");
            Database.getConnection().commit();
            // print all the countries in Europe
            System.out.println(countries);
            System.out.println(continents);
            Database.getConnection().close();
        } catch (SQLException | NullPointerException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
