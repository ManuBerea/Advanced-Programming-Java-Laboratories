package Commands;

import Exceptions.CommandException;
import bibliography.Catalog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand extends Command{
    private String jsonPath;

    public SaveCommand(Catalog catalog) {
        super(catalog);
        commandFormat = "save [path]";
    }

    @Override
    public void execute(String command) throws IOException, CommandException {
        parseArguments(command);

        if (commandArguments.get(0).equals("save")) {
            File file = new File(commandArguments.get(1));
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(catalog.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        else {
            throw new CommandException("Invalid save command format! Try: <" + commandFormat + ">");
        }
    }
}