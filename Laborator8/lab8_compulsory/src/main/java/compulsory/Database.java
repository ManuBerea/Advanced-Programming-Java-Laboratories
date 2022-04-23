package compulsory;

import java.sql.*;

/**
 * singleton class - create an unique object
 */
public class Database {
    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "STUDENT";
    private static final String PASSWORD = "STUDENT";
    private static Connection conn = null;

    private Database() throws SQLException {
        createConnection();
    }

    static void createConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            closeConnection();
        }
    }

    public static Connection getConnection() throws SQLException {
        if(conn == null){
            createConnection();
        }
        return conn;
    }

    public static void closeConnection() throws SQLException {
        if (conn != null)
            conn.close();
    }

    public static void rollback() {
    }
}

