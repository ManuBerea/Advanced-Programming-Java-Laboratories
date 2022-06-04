package com;

import com.database.DatabaseEditor;
import com.applications.open.MainFrame;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        MainFrame mainFrame = new MainFrame();
        mainFrame.setSize(900,600);
        mainFrame.setVisible(true);

        DatabaseEditor databaseEditor = new DatabaseEditor();

//          try {
//            databaseEditor.addDataFromCSVFile("C:\\Users\\manub\\IdeaProjects\\Proiect_spanzuratoarea\\words.txt");
//          } catch (SQLException e) {
//              e.printStackTrace();
//          }

//          databaseEditor.deleteData();

    }
}