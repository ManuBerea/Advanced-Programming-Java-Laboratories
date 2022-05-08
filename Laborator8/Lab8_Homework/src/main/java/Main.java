import database.DatabaseEditor;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        DatabaseEditor databaseEditor = new DatabaseEditor();
        databaseEditor.AddDataToDB();
        databaseEditor.addDataFromCSVFile("C:\\Users\\manub\\IdeaProjects\\Lab8_Homework\\capitals.txt");
//        System.out.print("Distance between cities Lima and Manila is: ");
        databaseEditor.distanceBetweenCities("Lima", "Manila");
    }
}