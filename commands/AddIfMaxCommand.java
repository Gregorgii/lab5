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
        StudyGroup studyGroup = studyGroupParser.parseStudyGroup();
        if (collectionManager.isMax(studyGroup)) {
            collectionManager.addToCollection(studyGroup);
            System.out.println("Элемент добавлен.");
        } else {
            System.out.println("Значение элемента меньше максимального.");
        }

    }

    if(collectionManager.getSize() == 0) this.collectionManager.add(dragon);
        else if (dragon.compareTo(collectionManager.getMin()) < 0){
        this.collectionManager.add(dragon);
        System.out.println("Element added");
    }
        else {
        System.out.println("Element not added. It is greater than min of collection");
    }

}

}

