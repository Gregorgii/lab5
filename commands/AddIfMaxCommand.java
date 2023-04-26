package commands;

import managers.CollectionManager;
import managers.IoManager;
import things.StudyGroup;

public class AddIfMaxCommand implements CommandInterface {
    private final CollectionManager collectionManager;
    private final IoManager ioManager;

    public AddIfMaxCommand(CollectionManager collectionManager, IoManager ioManager) {
        this.collectionManager = collectionManager;
        this.ioManager = ioManager;
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
        StudyGroup group = ioManager.requestStudyGroup();
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


