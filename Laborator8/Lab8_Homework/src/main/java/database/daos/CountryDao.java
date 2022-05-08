package database.daos;

import database.DatabaseConnection;
import database.entities.Continent;
import database.entities.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDao {
    private final PreparedStatement getById;
    private final PreparedStatement insertValue;
    private final PreparedStatement getByName;

    public CountryDao() throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        getById = conn.prepareStatement("select * from countries where id = ?");
        insertValue = conn.prepareStatement("insert into countries values (?, ?, ?, ?)");
        getByName = conn.prepareStatement("select * from cities where name = ?");

    }

    public Country findById(int id) throws SQLException {
        if (id < 1) {
            System.out.println("Invalid ID (must be over 0!)");
            return null;
        }

        getById.setInt(1, id);
        ResultSet result =  getById.executeQuery();

        Country country = null;

        while (result.next()) {
            country =  new Country();
            country.setId(result.getInt(1));
            country.setName(result.getString(2));
            country.setCode(result.getInt(3));
            country.setContinent(result.getString(4));
        }

        return country;
    }

    public Country findByName(String name) throws SQLException {

        getByName.setString(1, name); // 1 pt ca este primul "?"
        ResultSet result =  getByName.executeQuery(); // rezultatul executiei comenzii sql pregatite

        Country country = null;

        while (result.next()) {
            country =  new Country();
            country.setId(result.getInt(1));
            country.setName(result.getString(2));
            country.setCode(result.getInt(3));
            country.setContinent(result.getString(4));
        }
        return country;
    }

    public boolean insert(Country country) throws SQLException {
        if (country == null) {
            System.out.println("Cannot insert a null actor!");
            return false;
        }

        insertValue.setInt(1, country.getId());
        insertValue.setString(2, country.getName());
        insertValue.setInt(3, country.getCode());
        insertValue.setString(4, country.getContinent());

        return insertValue.execute();

    }

}

