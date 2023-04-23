package commands;

import managers.CollectionManager;
import managers.StudyGroupParser;
import things.StudyGroup;

public class AddIfMaxCommand implements CommandInterface {
    private final CollectionManager collectionManager;
    private final StudyGroupParser studyGroupParser;

    public AddIfMaxCommand(CollectionManager collectionManager, StudyGroupParser studyGroupParser) {
        this.collectionManager = collectionManager;
        this.studyGroupParser = studyGroupParser;
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
        StudyGroup groupToCompare = studyGroupParser.parseStudyGroup();
        if (collectionManager.isMax(groupToCompare)) {
            collectionManager.addToCollection(groupToCompare);
            System.out.println("Элемент добавлен.");
        } else {
            System.out.println("Значение элемента меньше максимального.");
        }

    }
}


