package com.labs.lab5.AppUtils;

import com.labs.lab5.AppObjects.AstartesCategory;
import com.labs.lab5.Exceptions.IncorrectCommandFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ConsoleManager {

    private static final CommandReader commandReader = new CommandReader();
    private final CommandInvoker commandInvoker;

    public static Integer id;
    public static AstartesCategory category;
    public static Boolean loyal;
    public static String path;

    public ConsoleManager(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    public static CommandReader getCommandReader(){
        return commandReader;
    }

    public static CommandStruct getCommandStruct() {
        try {
            return commandReader.readCommand();
        } catch (FileNotFoundException e){
            replyUser("File not found");
        } catch (IOException e){
            replyUser("File input error");
        } catch (IncorrectCommandFormatException e) {
            replyUser("Incorrect format of command", CommandReaderMode.CONSOLE);
        }
        return null;
    }

    public static void replyUser (String msg) {
        System.out.println(msg);
    }
    public static void replyUserInline(String msg){
        System.out.print(msg);
    }
    public static void replyUser (String msg, CommandReaderMode mode){
        if (commandReader.getCommandReaderMod() == mode) {
            System.out.println(msg);
        }
    }
    public static void replyUserInline(String msg, CommandReaderMode mode){
        if (commandReader.getCommandReaderMod() == mode) {
            System.out.print(msg);
        }
    }

    private Integer parseId(String str){
        try {
            id = Integer.parseInt(str);
            return id;
        } catch (NumberFormatException e){
            replyUser("Second argument must be a number");
            return null;
        }
    }

    private AstartesCategory parseCategory(String str){
        try {
            category = AstartesCategory.valueOf(str);
            return category;
        } catch (IllegalArgumentException e) {
            replyUser("There is no such category");
        }
        return null;
    }

    private Boolean parseLoyal(String str){
        if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false")) {
            loyal =  Boolean.parseBoolean(str);
            return true;
        }
        replyUser("Argument must be boolean");
        return null;
    }

    private String parsePath(String str){
        if (str == null || str.equals("")) {
            replyUser("Second argument must be the path");
            return null;
        }
        return str;
    }

    /**
     * Start user interaction
     */
    public void run() {
        commandReader.setConsoleMod();

        boolean session = true;
        do {
            replyUserInline("> ", CommandReaderMode.CONSOLE);

            CommandStruct command = getCommandStruct();

            if (!command.isHasCommand()){
                if (commandReader.getCommandReaderMod() == CommandReaderMode.FILE) {
                    commandReader.setConsoleMod();
                }
                else {
                    replyUser("Unknown command");
                }
                continue;
            }
            replyUser(String.format("> %s %s", commandReader.getFilePath(), command.getCommand()), CommandReaderMode.FILE);

            switch (command.getCommand()) {
                case "exit":
                    session = false;
                    break;
                case "save":
                    commandInvoker.save();
                    break;
                case "add":
                    commandInvoker.add();
                    break;
                case "info":
                    commandInvoker.info();
                    break;
                case "show":
                    commandInvoker.show();
                    break;
                case "help":
                    commandInvoker.help();
                    break;
                case "print_descending":
                    commandInvoker.printDescending();
                    break;
                case "clear":
                    commandInvoker.clear();
                    break;
                case "remove_lower":
                    commandInvoker.removeLower();
                    break;
                case "remove_last":
                    commandInvoker.removeLast();
                    break;
                case "update":
                    commandInvoker.update(command.getArgument());
                    break;
                case "remove_by_id":
                    commandInvoker.removeById(command.getArgument());
                    break;
                case "remove_at":
                    commandInvoker.removeAt(command.getArgument());
                    break;
                case "count_greater_than_category":
                    commandInvoker.countGreaterThanCategory(command.getArgument());
                    break;
                case "filter_less_than_loyal":
                    commandInvoker.filterLessThanLoyal(command.getArgument());
                    break;
                case "execute_script":
                    commandInvoker.executeScript(command.getArgument());
                    break;

                default:
                    replyUser("Unknown command");
            }

        } while (session);

    }

}
