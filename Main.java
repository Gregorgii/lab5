
import exceptions.NotEnoughArgs;
import managers.CollectionManager;
import commands.Executor;
import managers.FileManager;
import managers.IoManager;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws NotEnoughArgs, IOException {
        if(args.length == 0) throw new NotEnoughArgs("No file path specified");
        CollectionManager collectionManager = new CollectionManager(Paths.get(args[0]));

        FileManager fileManager = new FileManager(Paths.get(args[0]));
        fileManager.fillCollectionFromFile();

        Executor executor = new Executor(collectionManager, new IoManager());
        executor.enterInteractiveMode();
    }
}