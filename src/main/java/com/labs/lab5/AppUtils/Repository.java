package com.labs.lab5.AppUtils;

import com.labs.lab5.AppObjects.AstartesCategory;
import com.labs.lab5.AppObjects.SpaceMarine;

import java.util.*;

/**
 * Class of main repository
 */

public class Repository {

    private List<SpaceMarine> repository;
    private Date initializationDate;

    public Repository(){};

    public Repository(List<SpaceMarine> listType) {
        repository = listType;
        initializationDate = new Date();
    }

    public int getMaxId() {
        int maxId = 0;
        for (int i = 0; i < repository.size(); ++i) {
            int curId = repository.get(i).getId();
            if (curId > maxId){
                maxId = curId;
            }
        }
        return maxId;
    }

    private int size(){
        return repository.size();
    }

    public boolean isThereElementById(int id) {
        for (int i = 0; i < repository.size(); ++i) {
            if (repository.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }

    /**
     * Add new space marine to repository
     * @param spaceMarine SpaceMarine to adding
     */
    public boolean add(SpaceMarine spaceMarine){
        return repository.add(spaceMarine);
    }

    /**
     * Update element of repository by ID
     * @param id ID of the SpaceMarine being updated
     * @param spaceMarine New SpaceMarine
     */
    public boolean update(int id, SpaceMarine spaceMarine) {
        for (int i = 0; i < repository.size(); ++i) {
            if (repository.get(i).getId() == id){
                repository.set(i, spaceMarine);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove element of repository by ID
     * @param id ID of the SpaceMarine being removed
     */
    public boolean removeById(int id) {
        return repository.removeIf(n -> n.getId() == id);
    }

    /**
     * Clear repository
     */
    public boolean clear() {
        repository.clear();
        return true;
    }

    /**
     * Show info about repository
     */
    public boolean info() {
        ConsoleManager.replyUser(this.toString());
        return true;
    }

    /**
     * Show information about elements of repository
     */
    public boolean show() {
        StringBuilder description = new StringBuilder();
        int counter = 0;
        for (SpaceMarine elem : repository){
            description.append(elem.toString());
            if (counter != repository.size() - 1)
                description.append("\n");
            counter++;
        }
        ConsoleManager.replyUser(description.toString());
        return true;
    }

    /**
     * @param index Index of the element being removed
     */
    public boolean removeAt(int index){
        if (this.size() < index || index < 1) return false;
        repository.remove(index-1);
        return true;
    }

    /**
     * Remove last element from repository
     */
    public boolean removeLast(){
        int index = repository.size() - 1;
        if (index < 0) return false;
        repository.remove(index);
        return true;
    }

    /**
     * Remove all elements with less health than given
     * @param spaceMarine SpaceMarine to compare
     */
    public boolean removeLower(SpaceMarine spaceMarine) {
        return repository.removeIf(n -> n.compareTo(spaceMarine) < 0);
    }

    /**
     * Counts the number of elements for which category greater than given
     * @param category Given category
     */
    public boolean countGreaterThanCategory(AstartesCategory category) {
        String iterCategory;
        String givenCategory;
        int counter = 0;
        for (SpaceMarine elem : repository) {
            iterCategory = elem.getCategory().toString();
            givenCategory = category.toString();
            if (iterCategory.compareTo(givenCategory) > 0){
                counter++;
            };
        }
        if (counter > 0) {
            ConsoleManager.replyUser(counter + " elements have category greater than given");
            return true;
        }
        return false;
    }

    /**
     * Show all elements for which loyal less than given
     * @param loyal Given loyal
     */
    public boolean filterLessThanLoyal(boolean loyal) {
        String givenLoyalString = Boolean.toString(loyal);
        boolean isNotEmpty = false;
        for (SpaceMarine elem : repository) {
            String elemLoyalString = Boolean.toString(elem.getLoyal());
            if (givenLoyalString.compareTo(elemLoyalString) > 0){
                ConsoleManager.replyUser(elem.toString());
                isNotEmpty = true;
            }
        }
        return isNotEmpty;
    }

    /**
     * Print elements of repository in descending order
     */
    public boolean printDescending() {
        if (repository.isEmpty()) return false;
        List<SpaceMarine> sortedRepository = new ArrayList<>(repository);
        sortedRepository.sort(Comparator.comparingInt(SpaceMarine::getId));
        StringBuilder description = new StringBuilder();
        for (SpaceMarine elem : sortedRepository){
            description.append(elem.toString()).append("\n");
        }
        ConsoleManager.replyUser(description.toString());
        return true;
    }


    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;

        Repository other = (Repository) otherObject;
        return repository.equals(other.repository) && initializationDate.equals(other.initializationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository, initializationDate);
    }

    @Override
    public String toString() {
        return "'Repository info'" +
                "\nType: " + repository.getClass().getName() +
                "\nSize: " + this.size() +
                "\nInitialization Date: " + initializationDate;
    }
}