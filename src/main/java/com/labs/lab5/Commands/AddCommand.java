package com.labs.lab5.Commands;

import com.labs.lab5.AppObjects.SpaceMarine;
import com.labs.lab5.AppUtils.MarineCreator;
import com.labs.lab5.AppUtils.Repository;


public class AddCommand extends AbstractCommand {
    private Repository repository;
    private MarineCreator marineCreator;
    private SpaceMarine spaceMarine;

    public AddCommand(Repository repository, MarineCreator marineCreator) {
        super("add {element}", "Add new element to repository");
        this.repository = repository;
        this.marineCreator = marineCreator;
    }

    @Override
    public boolean execute() {
        spaceMarine = marineCreator.create();
        if (spaceMarine == null)
            return false;
        return repository.add(spaceMarine);
    }
}
