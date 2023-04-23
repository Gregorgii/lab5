package commands;

import managers.CollectionManager;
import managers.IoManager;

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
        int transferredStudents = IoManager.inputInt("Введите значение поля transferredStudents:");
        System.out.println("Количество элементов, значение поля transferredStudents которых больше " + transferredStudents + ": " + collectionManager.countGreaterThanTransferredStudents(transferredStudents));
    }


}
