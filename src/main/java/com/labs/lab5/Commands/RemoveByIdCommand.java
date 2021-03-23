package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.ConsoleManager;
import com.labs.lab5.AppUtils.Repository;

public class RemoveByIdCommand extends AbstractCommand {
    private Repository repository;
    public static int id;

    public RemoveByIdCommand(Repository repository){
        super("remove_by_id id", "Remove element from repository by ID");
        this.repository = repository;
    }

    @Override
    public boolean execute(){
        return repository.removeById(ConsoleManager.id);
    }
}
