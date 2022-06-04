package com.database;

import java.sql.*;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private final Connection connection;

    private DatabaseConnection() throws SQLException {
         System.out.println("Connecting to database...");
         connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "STUDENTSGBD", "STUDENTSGBD");
         System.out.println("Connected!");
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
