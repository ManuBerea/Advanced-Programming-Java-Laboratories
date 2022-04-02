package Commands;

import Exceptions.CommandException;
import Exceptions.ItemException;
import bibliography.Catalog;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Command {
    String commandFormat;
    Catalog catalog;
    List<String> commandArguments;

    public Command(Catalog catalog) {
        this.catalog = catalog;
        commandArguments = new LinkedList<>();
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public String getCommandFormat() {
        return commandFormat;
    }

    public abstract void execute(String arguments) throws CommandException, ItemException, IOException, ClassNotFoundException, ItemException, ParseException;

    public void parseArguments(String arguments) {
        this.commandArguments.addAll(Arrays.asList(arguments.split(" ")));
    }
}
