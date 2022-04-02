package Commands;

import Exceptions.CommandException;
import bibliography.Catalog;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command{
    public ViewCommand(Catalog catalog) {
        super(catalog);
        commandFormat = "view [path]";
    }

    public void execute(String command) throws CommandException, IOException {
        parseArguments(command);

        if (commandArguments.get(0).equals("view")) {
            try {
                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                }

                assert desktop != null;
                desktop.open(new File(commandArguments.get(1)));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        else {
            throw new CommandException("Invalid view command format! Try: <" + commandFormat + ">");
        }
    }
}
