package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.Repository;

public class ShowCommand extends AbstractCommand{
    Repository repository;

    public ShowCommand(Repository repository) {
        super("show", "Show information about elements of repository");
        this.repository = repository;
    }

    @Override
    public boolean execute() {
        return repository.show();
    }
}
