package Commands;

import Exceptions.CommandException;
import Exceptions.ItemException;
import Resources.*;
import bibliography.Catalog;

public class AddCommand extends Command {
    public AddCommand(Catalog catalog) {
        super(catalog);
        commandFormat = "add [book / article] [title] [location] [type]";
    }

    @Override
    public void execute(String command) throws CommandException, ItemException {
        parseArguments(command);

        if (this.commandArguments.get(0).equals("add") && this.commandArguments.get(1).equals("book")) {
            Item newItem = new Book(commandArguments.get(2), commandArguments.get(3), commandArguments.get(4));
            catalog.addItem(newItem);
        }
        else if (this.commandArguments.get(0).equals("add") && commandArguments.get(1).equals("article")) {
            Item newItem = new Article(commandArguments.get(2), commandArguments.get(3), commandArguments.get(4));
            catalog.addItem(newItem);
        }
        else {
            throw new CommandException("Invalid add command format! Try: <" + commandFormat + ">");
        }
    }
}
