package managers;
import java.io.IOException;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

import things.*;

public class CollectionManager {
    private final ArrayList<StudyGroup> groupCollection;
    private final Path defaultPath;
    private final ZonedDateTime creationDate;

    public CollectionManager(Path filePath) throws IOException {

        defaultPath = filePath;
        groupCollection = new ArrayList<>();
        this.creationDate = ZonedDateTime.now();
        loadCollection(defaultPath);
    }
    /**
     * @return The collection itself.
     */
    public ArrayList<StudyGroup> getCollection(){
        return groupCollection;
    }

    /**
     * Returns s default file path specified in class.
     * @return path
     */
    public Path getPath(){
        return defaultPath;
    }


    public String getInfo() {
        String result = "";
        result += "Information about collection:\n";
        result += "Created at " + this.creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + '\n';
        result += "Collection type is " + this.groupCollection.getClass().getName() + '\n';
        result += "Amount of items stored in - " + this.groupCollection.size() + '\n';
        return result;
    }

    public Iterator<StudyGroup> getIterator(){
        return groupCollection.iterator();
    }



    /**
     * Get collection size
     *
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
     * @param studyGroup A group to add.
     */
    public void addToCollection(StudyGroup studyGroup) {
        groupCollection.add(studyGroup);
    }

    /**
     * Removes object from collection with specified id.
     * @param id id of object to be removed from collection.
     * @return true if object was removed successfully, false if object with spec. id does now exist.
     */
    public boolean removeByID(int id){
        for(int index = 0; index < groupCollection.size(); index++){
            if(groupCollection.get(index).getId() == id){
                this.removeByIndex(index);
                return true;
            }
        }
        return false;
    }

    /**
     * Get element with min. value
     * @return dragon object with min. value
     */
    public StudyGroup getMax(){
        if(groupCollection.size() > 0) return Collections.max(groupCollection);
        return null;
    }


    /**
     * Removes element with specified index
     * @param index object to be removed index
     * @throws IndexOutOfBoundsException when elements with such index does not exist
     */
    public void removeByIndex(int index) throws IndexOutOfBoundsException{
        groupCollection.remove(index);
    }

    /**
     * Remove group greater than the selected one.
     * @param groupToCompare A group to compare with.
     */
    public void removeGreater(StudyGroup groupToCompare) throws IOException {
        int counter = 0;

        for (StudyGroup group : groupCollection){
            if(group.compareTo(groupToCompare) > 0) {
                removeByID(group.getId());
                counter += 1;
            }
        }
        System.out.println(counter + " elements was removed");
    }


    /**
     * Get stream
     * @return stream
     */
    public Stream<StudyGroup> getStream(){
        return groupCollection.stream();
    }

    /**
     * Generates next ID. It will be (the bigger one + 1).
     * @return Next ID.
     */
    public Integer generateNextId() {
        if (groupCollection.isEmpty()) return 1;
        return (int) (groupCollection.get(groupCollection.size() - 1).getId() + 1);
    }


    /**
     * Loads the collection from file.
     */
    private void loadCollection(Path defaultPath) {
        FileManager fileManager = new FileManager(defaultPath);
        fileManager.fillCollectionFromFile(defaultPath);
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



}



