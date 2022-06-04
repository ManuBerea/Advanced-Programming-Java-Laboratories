package com.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DatabaseEditor {

    public DatabaseEditor() {
    }

    public void addDataFromCSVFile(String path) throws SQLException, IOException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        conn.setAutoCommit(false);

        String sql = "INSERT INTO words (id, word_name, word_language, word_difficulty) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        BufferedReader lineReader = new BufferedReader(new FileReader(path));
        String lineText;

        lineReader.readLine(); // skip header line

        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(",");
            String id = data[0];
            String word_name = data[1];
            String word_language = data[2];
            String word_difficulty = data[3];

            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.setString(2, word_name);
            pstmt.setString(3, word_language);
            pstmt.setString(4, word_difficulty);

            pstmt.addBatch();
            pstmt.executeBatch();
        }

        lineReader.close();

        // execute the remaining queries
        pstmt.executeBatch();
        conn.commit();
        System.out.println("Data added successfully!");
    }

    public void deleteData() throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try {
            String sql = "DELETE from words";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("Data deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


