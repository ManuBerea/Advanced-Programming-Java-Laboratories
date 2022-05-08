package database.daos;

import database.DatabaseConnection;
import database.entities.City;
import database.entities.Continent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContinentDao {
    private final PreparedStatement getById;
    private final PreparedStatement insertValue;
    private final PreparedStatement getByName;

    public ContinentDao() throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        getById = conn.prepareStatement("select * from continents where id = ?");
        insertValue = conn.prepareStatement("insert into continents values (?, ?)");
        getByName = conn.prepareStatement("select * from cities where name = ?");
    }

    public Continent findById(int id) throws SQLException {
        if (id < 1) {
            System.out.println("Invalid ID (must be over 0!)");
            return null;
        }

        getById.setInt(1, id);
        ResultSet result =  getById.executeQuery();

        Continent continent = null;

        while (result.next()) {
            continent =  new Continent();
            continent.setId(result.getInt(1));
            continent.setName(result.getString(2));

        }
        return continent;
    }

    public Continent findByName(String name) throws SQLException {
        getByName.setString(1, name); // 1 pt ca este primul "?"
        ResultSet result =  getByName.executeQuery(); // rezultatul executiei comenzii sql pregatite

        Continent continent = null;

        while (result.next()) { //
            continent =  new Continent();
            continent.setId(result.getInt(1));
            continent.setName(result.getString(2));
        }
        return continent;
    }

    public boolean insert(Continent continent) throws SQLException {
        if (continent == null) {
            System.out.println("Cannot insert a null actor!");
            return false;
        }

        insertValue.setInt(1, continent.getId());
        insertValue.setString(2, continent.getName());

        return insertValue.execute();

    }

}
