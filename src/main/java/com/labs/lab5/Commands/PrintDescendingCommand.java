package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.Repository;

public class PrintDescendingCommand extends AbstractCommand {
    Repository repository;

    public PrintDescendingCommand(Repository repository) {
        super("print_descending", "Print elements of repository in descending order");
        this.repository = repository;
    }
    @Override
    public boolean execute() {
        return repository.printDescending();
    }
}
