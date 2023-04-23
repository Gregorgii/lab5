package commands;

import managers.CollectionManager;
import managers.StudyGroupParser;
import things.StudyGroup;

import java.io.IOException;

public class RemoveGreaterCommand implements CommandInterface {
    private final CollectionManager collectionManager;
    private final StudyGroupParser studyGroupParser;

    public RemoveGreaterCommand(CollectionManager collectionManager, StudyGroupParser studyGroupParser) {
        this.collectionManager = collectionManager;
        this.studyGroupParser = studyGroupParser;
    }

    @Override
    public void execute(String[] args) throws IOException {
        StudyGroup studyGroup = studyGroupParser.parseStudyGroup();
        collectionManager.removeGreater(studyGroup);
        System.out.println("Элементы удалены.");
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

}
