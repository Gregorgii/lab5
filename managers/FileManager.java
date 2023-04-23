package managers;


import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import things.StudyGroup;

import javax.naming.NoPermissionException;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Class for work with collection.
 */
public class FileManager {

    private final Path defaultPath;
    private final ArrayList<StudyGroup> groupCollection;
    private final LocalDate creationDate;


    /**
     * Constructor. Creates abject to work with collection.
     */
    public FileManager(Path filePath){
        defaultPath = filePath;
        groupCollection = new ArrayList<>();
        this.creationDate = LocalDate.now();
    }

    /**
     * Returns s default file path specified in class.
     * @return path
     */
    public Path getPath(){
        return defaultPath;
    }

    /**
     * Adds object to collection
     * @param dragon object to add
     */
    public void add(StudyGroup group){
        groupCollection.add(group);
    }

    /**
     * Removes all elements from collection
     */
    public void clearCollection() {
        this.groupCollection.clear();
    }

    /**
     * Removes object from collection with specified id.
     * @param id id of object to be removed from collection.
     * @return true if object was removed successfully, false if object with spec. id does now exist.
     */
    public boolean removeById(long id){
        for(int index = 0; index < groupCollection.size(); index++){
            if(groupCollection.get(index).getId() == id){
                this.removeByIndex(index);
                return true;
            }
        }
        return false;
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
     * Get info about collection
     * @return string with info about collection
     */
    public String getInfo(){
        String result = "";
        result += "Information about collection:\n";
        result += "Created at " + this.creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + '\n';
        result += "Collection type is " + this.groupCollection.getClass().getName() + '\n';
        result += "Amount of items stored in - " + this.groupCollection.size() + '\n';

        return result;
    }


    /**
     * Fill collection from file from default file path
     */
    public void fillCollectionFromFile(){
        fillCollectionFromFile(defaultPath);
    }

    /**
     * Fill collection from file
     * @param path path to .csv file to load from
     */
    public void fillCollectionFromFile(Path path){

        // check if file exist
        try{
            if(!Files.exists(path)) throw new FileNotFoundException("File " + path + " not found");
            if(!Files.isReadable(path)) throw new NoPermissionException("Cannot read file.");
            if(!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file.");
        }
        catch (InvalidPathException e){
            System.out.println("Argument must be a correct file path. Data not loaded.");
            return;
        }
        catch (FileNotFoundException e){
            System.out.println("File " + path + " not found. Data not loaded."); // file does not exist
            return;
        }
        catch (NoPermissionException e){
            System.out.print("No enough permissions to " + path + " - " + e.getMessage() + " Data not loaded."); // permissions deny
            return;
        }

        try (BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(path))){

            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            CsvToBean<StudyGroup> csv = new CsvToBeanBuilder<StudyGroup>(reader).withType(StudyGroup.class).build();

            groupCollection.addAll(csv.parse());

            System.out.println(groupCollection.size() + " item(s) loaded from file " + path);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());}
        catch (Throwable e){
            System.out.println("An error occurred while reading file. Data not loaded.");
        }
    }


}