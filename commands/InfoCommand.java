package commands;

import managers.CollectionManager;

public class InfoCommand implements CommandInterface {
    private final CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println(collectionManager.getInfo());
    }

    @Override
    public String getDescription() {
        return "standard stream with info about collection";
    }

    @Override
    public String getName() {
        return "Info";
    }

}
