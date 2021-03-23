package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.ConsoleManager;
import com.labs.lab5.AppUtils.Repository;

public class FilterLessThanLoyalCommand extends AbstractCommand{
    Repository repository;

    public FilterLessThanLoyalCommand(Repository repository) {
        super("filter_less_than_loyal loyal", "Show all elements for which loyal less than given");
        this.repository = repository;
    }
    @Override
    public boolean execute() {
        return repository.filterLessThanLoyal(ConsoleManager.loyal);
    }
}
