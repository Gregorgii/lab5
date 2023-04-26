package commands;

import managers.CollectionManager;
import managers.IoManager;
import things.StudyGroup;

import java.util.Iterator;

public class RemoveAnyByShouldBeExpelledCommand implements CommandInterface {
    private final CollectionManager collectionManager;

    public RemoveAnyByShouldBeExpelledCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        IoManager ioManager = new IoManager();
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void execute(String[] args) {
        boolean flag = false;
        IoManager ioManager = new IoManager();
        int should_be_exp = ioManager.inputInt();
        Iterator<StudyGroup> iter = collectionManager.getIterator();
        if (collectionManager.getSize() > 0){
            while (iter.hasNext()){
                if (iter.next().getShouldBeExpelled() == should_be_exp){
                    flag = true;
                    collectionManager.removeByID(iter.next().getId());
                    break;
                }
            } if (!flag){
                System.out.println("Error: element is not exist");
            } else {
                System.out.println("Successfully");
            }
        }
    }
}
