import compulsory.Database;

import java.sql.*;

public class CountryDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into COUNTRIES (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from COUNTRIES where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        return "ana";
    }
}
