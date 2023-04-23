package managers;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import things.*;

public class CollectionManager {
    private final ArrayList<StudyGroup> groupCollection;

    public CollectionManager(Path filePath) throws IOException {

        groupCollection = new ArrayList<>();
        loadCollection();
    }
    /**
     * @return The collection itself.
     */
    public ArrayList<StudyGroup> getCollection(){
        return groupCollection;
    }

    /**
     * @return Size of the collection.
     */
    public int collectionSize() {
        return groupCollection.size();
    }

    /**
     * @return The first element of the collection or null if collection is empty.
     */
    public StudyGroup getFirst() {
        if (groupCollection.isEmpty()) return null;
        return groupCollection.get(0);
    }

    /**
     * @return The last element of the collection or null if collection is empty.
     */
    public StudyGroup getLast() {
        if (groupCollection.isEmpty()) return null;
        return groupCollection.get(groupCollection.size()-1);
    }

    /**
     * Get element with min. value
     * @return dragon object with min. value
     */
    public StudyGroup getMin(){
        if(groupCollection.size() > 0) return Collections.min(groupCollection);
        return null;
    }

    /**
     * Get collection size
     * @return number of elements stored in collection
     */
    public int getSize(){
        return groupCollection.size();
    }

    /**
     * @param id ID of the group.
     * @return A group by his ID or null if group isn't found.
     */
    public StudyGroup getById(Integer id) {
        for (StudyGroup studyGroup: groupCollection) {
            if (Objects.equals(studyGroup.getId(), id)) return studyGroup;
        }
        return null;
    }

    /**
     * Adds a new group to collection.
     * @param group A group to add.
     */
    public void addToCollection(StudyGroup studyGroup) {
        groupCollection.add(studyGroup);
    }

    /**
     * Removes a group from collection.
     * @param group A group to remove.
     */
    public void removeByID(Integer id) {
        groupCollection.removeIf(groupCollection -> Objects.equals(groupCollection.getId(), id));
    }

    /**
     * Remove group greater than the selected one.
     * @param groupToCompare A group to compare with.
     */
    public void removeGreater(StudyGroup groupToCompare) {
        groupCollection.removeIf(groupCollection -> groupCollection.compareTo(groupToCompare) > 0);
    }

    /**
     * Clears the collection.
     */
    public void clearCollection() {
        groupCollection.clear();
    }

    /**
     * Generates next ID. It will be (the bigger one + 1).
     * @return Next ID.
     */
    public Long generateNextId() {
        if (groupCollection.isEmpty()) return 1L;
        return (long) (groupCollection.get(groupCollection.size() - 1).getId() + 1);
    }

    /**
     * Saves the collection to file.
     * @throws IOException
     */
    public void saveCollection() throws IOException {
        String filename = IoManager.inputString(IoManager.inputString());

        fileManager.writeCollection(groupCollection, fileName);
    }

    /**
     * Loads the collection from file.
     * @throws IOException
     */
    private void loadCollection() throws IOException {
       groupCollection = fileManager.readCollection(null);
    }

    @Override
    public String toString() {
        if (groupCollection.isEmpty()) return "Коллекция пуста!";

        StringBuilder info = new StringBuilder();
        for (StudyGroup studyGroup : groupCollection) {
            info.append(studyGroup);
            if (studyGroup != groupCollection.get(groupCollection.size()-1)) info.append("\n\n");
        }
        return info.toString();
    }
    public Object infoAboutCollection() {
        return null;
    }
}



