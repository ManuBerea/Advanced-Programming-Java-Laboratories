import Commands.*;
import Exceptions.CommandException;
import Exceptions.ItemException;
import bibliography.Catalog;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            Catalog catalog = new Catalog("Catalog1", "C:/Users/manub/IdeaProjects/Lab5_homework/src/main/resources/items.json");

            while (true) {
                System.out.print("Type your command:");
                String command = input.nextLine();
                String commandName = new Scanner(command).next();
                switch (commandName) {
                    case "add" -> {
                        AddCommand addCommand = new AddCommand(catalog);
                        addCommand.execute(command);
                    }
                    case "save" -> {
                        SaveCommand saveCommand = new SaveCommand(catalog);
                        saveCommand.execute(command);
                    }
                    case "load" -> {
                        LoadCommand loadCommand = new LoadCommand(catalog);
                        loadCommand.execute(command);
                    }
                    case "list" -> {
                        ListCommand listCommand = new ListCommand(catalog);
                        listCommand.execute(command);
                    }
                    case "view" -> {
                        ViewCommand viewCommand = new ViewCommand(catalog);
                        viewCommand.execute(command);
                    }
                    case "report" -> {
                        ReportCommand reportCommand = new ReportCommand(catalog);
                        reportCommand.execute(command);
                    }
                    case "exit" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> throw new ItemException("Command not supported!");
                }
            }
        }
        catch (ItemException | CommandException exp) {
            System.out.println(exp.getMessage());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
