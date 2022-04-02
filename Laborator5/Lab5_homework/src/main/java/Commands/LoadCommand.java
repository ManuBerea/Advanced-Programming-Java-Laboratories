package Commands;

import Exceptions.CommandException;
import Exceptions.ItemException;
import Resources.Article;
import Resources.Book;
import Resources.Item;
import bibliography.Catalog;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class LoadCommand extends Command{

    public LoadCommand(Catalog catalog) {
        super(catalog);
        commandFormat = "load [path]";
    }

    public void execute(String command) throws ItemException, IOException, ParseException, CommandException {
        parseArguments(command);

        if (commandArguments.get(0).equals("load")) {
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(new FileReader(commandArguments.get(1)));

            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = (JSONObject) array.get(i);

                String title = (String) obj.get("title");
                String location = (String) obj.get("location");
                String type = (String) obj.get("type");

                if (null != type) {
                    if (type.equals("book")) {
                        Item newItem = new Book(title, location, type);
                        catalog.addItem(newItem);
                    } else if (type.equals("article")) {
                        Item newItem = new Article(title, location, type);
                        catalog.addItem(newItem);
                    }
                }
            }
        }
        else {
            throw new CommandException("Invalid load command format! Try: <" + commandFormat + ">");
        }
    }
}
