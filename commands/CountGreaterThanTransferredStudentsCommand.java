package commands;

import managers.CollectionManager;
import managers.IoManager;
import things.StudyGroup;

import java.util.Iterator;

public class CountGreaterThanTransferredStudentsCommand implements CommandInterface {
    private final CollectionManager collectionManager;

    public CountGreaterThanTransferredStudentsCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }


    @Override
    public String getDescription() {
        return "print count of groups where count of transferredStudents more than inputted";
    }

    @Override
    public String getName() {
        return "CountGreaterThanTransferredStudentsCommand";
    }

    @Override
    public void execute(String[] args) {
        IoManager ioManager = new IoManager();
        int transferredStudents = ioManager.inputInt();
        int count = 0;
        Iterator<StudyGroup> iter = collectionManager.getIterator();
        if (collectionManager.getSize() > 0){
            while (iter.hasNext()){
                if (iter.next().getTransferredStudents() > transferredStudents){
                    count += 1;
                }
            } if (count == 0){
                System.out.println("Error: elements with this field doesn't exist");
            } else {
                System.out.println("There is elements with count of tranf greater than input is: " + count);
            }
        }
    }


}
