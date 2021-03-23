package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.Repository;

public class RemoveLastCommand extends AbstractCommand{
    Repository repository;

    public RemoveLastCommand(Repository repository) {
        super("remove_last", "Remove last element from collection");
        this.repository = repository;
    }

    @Override
    public boolean execute() {
        return repository.removeLast();
    }
}
