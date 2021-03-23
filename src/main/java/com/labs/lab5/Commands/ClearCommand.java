package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.Repository;

public class ClearCommand extends AbstractCommand{
    Repository repository;

    public ClearCommand(Repository repository) {
        super("clear", "Clear repository");
        this.repository = repository;
    }

    @Override
    public boolean execute(){
        return repository.clear();
    }
}
