package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.Repository;

public class InfoCommand extends AbstractCommand{
    Repository repository;

    public InfoCommand(Repository repository) {
        super("info", "Show info about current repository");
        this.repository = repository;
    }

    @Override
    public boolean execute() {
        return repository.info();
    }
}
