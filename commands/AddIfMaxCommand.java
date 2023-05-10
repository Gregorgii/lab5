package commands;

import managers.CollectionManager;
import managers.IoManager;
import things.StudyGroup;

public class AddIfMaxCommand implements CommandInterface {
    private final CollectionManager collectionManager;


    public AddIfMaxCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getDescription() {
        return "add element if max";
    }

    @Override
    public String getName() {
        return "add if max";
    }

    @Override
    public void execute(String[] args) {
        IoManager ioManager = new IoManager();
        StudyGroup group = ioManager.requestStudyGroup(collectionManager);
        if(collectionManager.getSize() == 0) this.collectionManager.addToCollection(group);
        else if (group.compareTo(collectionManager.getMax()) > 0){
            this.collectionManager.addToCollection(group);
            System.out.println("Element added");
        }
        else {
            System.out.println("Element not added. It is greater than min of collection");
        }
    }
}


