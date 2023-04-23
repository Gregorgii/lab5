package commands;

import managers.IoManager;


import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ExecuteScriptCommand implements CommandInterface{

    private final Scanner scanner;
    private final ArrayList<String> executedFiles;
    public ExecuteScriptCommand(Scanner scanner, ArrayList<String> executedFiles) {
        this.scanner = scanner;
        this.executedFiles = executedFiles;
    }
    @Override
    public void execute(, String arguments) {

        String pathToFileWithScript = "";
        if (arguments == null) {
            while (pathToFileWithScript.isBlank()) {
                System.out.print("Введите путь до файла со скриптом: ");
                pathToFileWithScript = scanner.nextLine();
            }
        } else {
            pathToFileWithScript = arguments;
        }


        Path file = Paths.get(pathToFileWithScript);


        if (Files.exists(file) && Files.isReadable(file)) {
            executedFiles.add(pathToFileWithScript);
            try (Scanner scannerForFile = new Scanner(file.toFile())) {
                while (scannerForFile.hasNext()) {
                    String command = scannerForFile.nextLine();
                    execute(command);
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "Execute script from file";
    }

    @Override
    public String getName() {
        return "ExecuteScript";
    }


}
    