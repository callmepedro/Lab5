package com.labs.lab5.App;


import com.labs.lab5.AppUtils.CommandInvoker;
import com.labs.lab5.AppUtils.ConsoleManager;
import com.labs.lab5.AppUtils.MarineCreator;
import com.labs.lab5.AppUtils.Repository;
import com.labs.lab5.Commands.*;

import java.util.ArrayList;


/**
 * Main application class.
 * @author Petr Soloviev
 */
public class Main {

    public static void main(String[] args) {
        System.setProperty("illegal-access", "deny");


        Repository repository = new Repository(new ArrayList<>());
        MarineCreator marineCreator = new MarineCreator();

        CommandInvoker commandInvoker = new CommandInvoker(
                new AddCommand(repository, marineCreator),
                new UpdateCommand(repository, marineCreator),
                new RemoveByIdCommand(repository),
                new ClearCommand(repository),
                new InfoCommand(repository),
                new ShowCommand(repository),
                new RemoveAtCommand(repository),
                new RemoveLastCommand(repository),
                new RemoveLowerCommand(repository, marineCreator),
                new CountGreaterThanCategoryCommand(repository),
                new FilterLessThanLoyalCommand(repository),
                new PrintDescendingCommand(repository),
                new ExecuteScriptCommand(),
                new SaveCommand(repository),
                new HelpCommand()
        );

        ConsoleManager consoleManager = new ConsoleManager(commandInvoker);

        consoleManager.run();
    }
}
