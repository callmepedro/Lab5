package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.ConsoleManager;
import com.labs.lab5.AppUtils.MarineCreator;
import com.labs.lab5.AppUtils.Repository;

public class UpdateCommand extends AbstractCommand {
    private Repository repository;
    private MarineCreator marineCreator;

    public UpdateCommand(Repository repository, MarineCreator marineCreator) {
        super("update id {element}", "Update value of Repository's element by ID");
        this.repository = repository;
        this.marineCreator = marineCreator;
    }

    @Override
    public boolean execute() {
        if (repository.isThereElementById(ConsoleManager.id))
            return repository.update(ConsoleManager.id, marineCreator.create());

        return false;
    }
}