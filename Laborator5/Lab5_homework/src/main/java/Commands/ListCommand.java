package Commands;

import Exceptions.CommandException;
import Resources.Item;
import bibliography.Catalog;


public class ListCommand extends Command {
    public ListCommand(Catalog catalog) {
        super(catalog);
        commandFormat = "list";
    }

    @Override
    public void execute(String arguments) throws CommandException {
        parseArguments(arguments);
        if (commandArguments.get(0).equals("list")) {
            for (Item i : catalog.getItems()) {
                System.out.println(i.toString());
            }
        }
        else {
            throw new CommandException("Invalid list call! To call, write this <" + commandFormat + ">");
        }
    }

}
