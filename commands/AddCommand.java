package commands;

import managers.CollectionManager;
import managers.IoManager;


public class AddCommand implements CommandInterface {
    private final CollectionManager collectionManager;


    public AddCommand(CollectionManager collectionManager, IoManager ioManger) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getDescription() {
        return "Add new item to collection";
    }

    @Override
    public String getName() {
        return "Add";
    }

    @Override
    public void execute(String[] args) {
        IoManager ioManager = new IoManager();
        collectionManager.addToCollection(ioManager.requestStudyGroup());
    }

}