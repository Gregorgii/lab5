package commands;

import managers.CollectionManager;
import managers.StudyGroupParser;


public class AddCommand implements CommandInterface {
    private final CollectionManager collectionManager;
    private final StudyGroupParser studyGroupParser;

    public AddCommand(CollectionManager collectionManager, StudyGroupParser studyGroupParser) {
        super();
        this.collectionManager = collectionManager;
        this.studyGroupParser = studyGroupParser;
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
        collectionManager.addToCollection(studyGroupParser.parseStudyGroup());
    }

}