package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.ConsoleManager;
import com.labs.lab5.AppUtils.Repository;

public class CountGreaterThanCategoryCommand extends AbstractCommand{
    Repository repository;
    public CountGreaterThanCategoryCommand(Repository repository){
        super("count_greater_than_category category", "Counts the number of elements for which category greater than given");
        this.repository = repository;
    }

    @Override
    public boolean execute() {
        return repository.countGreaterThanCategory(ConsoleManager.category);
    }
}
