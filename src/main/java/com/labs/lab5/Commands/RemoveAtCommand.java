package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.ConsoleManager;
import com.labs.lab5.AppUtils.Repository;

public class RemoveAtCommand extends AbstractCommand{
    Repository repository;

    public RemoveAtCommand(Repository repository) {
        super("remove_at index", "Remove element by index");
        this.repository = repository;
    }
    @Override
    public boolean execute() {
        return repository.removeAt(ConsoleManager.id);
    }
}
