package commands;

import managers.CollectionManager;

public class ClearCommand implements CommandInterface {
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getDescription() {
        return "Clear collection";
    }

    @Override
    public String getName() {
        return "Clear";
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clearCollection();
        System.out.println("Коллекция очищена.");
    }

}
