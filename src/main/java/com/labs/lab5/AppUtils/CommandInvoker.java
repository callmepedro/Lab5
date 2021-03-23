package com.labs.lab5.AppUtils;

import com.labs.lab5.Commands.Command;
import com.labs.lab5.Commands.HelpCommand;

/**
 * Class calls execute methods on command objects
 */
public class CommandInvoker {

    Command addCommand;
    Command updateCommand;
    Command removeByIdCommand;
    Command clearCommand;
    Command infoCommand;
    Command showCommand;
    Command removeAtCommand;
    Command removeLast;
    Command removeLower;
    Command countGreaterThanCategory;
    Command filterLessThanLoyal;
    Command printDescending;
    Command executeScript;
    Command saveCommand;
    Command helpCommand;

    public CommandInvoker(Command addCommand, Command updateCommand, Command removeByIdCommand, Command clearCommand,
                          Command infoCommand, Command showCommand, Command removeAtCommand, Command removeLast,
                          Command removeLower, Command countGreaterThanCategory, Command filterLessThanLoyal,
                          Command printDescending, Command executeScript, Command saveCommand, Command helpCommand) {
        this.addCommand = addCommand;
        this.updateCommand = updateCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.clearCommand = clearCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.removeAtCommand = removeAtCommand;
        this.removeLast = removeLast;
        this.removeLower = removeLower;
        this.countGreaterThanCategory = countGreaterThanCategory;
        this.filterLessThanLoyal = filterLessThanLoyal;
        this.printDescending = printDescending;
        this.executeScript = executeScript;
        this.helpCommand = helpCommand;
        this.saveCommand = saveCommand;

        HelpCommand.giveCommandInvokerObjToHelpCommand(this);
    }


    public boolean add() { return addCommand.execute(); }

    public boolean update(){ return updateCommand.execute(); }

    public boolean removeById(){ return removeByIdCommand.execute(); }

    public boolean clear(){ return clearCommand.execute();}

    public boolean info() {return infoCommand.execute();}

    public boolean show() {return showCommand.execute();}

    public boolean removeAt() {return removeAtCommand.execute();}

    public boolean removeLast() {return removeLast.execute();}

    public boolean removeLower() {return removeLower.execute();}

    public boolean countGreaterThanCategory() {return countGreaterThanCategory.execute();}

    public boolean filterLessThanLoyal() {return filterLessThanLoyal.execute();}

    public boolean printDescending() { return printDescending.execute();}

    public boolean executeScript() { return executeScript.execute();}

    public boolean save() {return saveCommand.execute();}

    public boolean help() { return helpCommand.execute();}
}
