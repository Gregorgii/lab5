package commands;

import exceptions.NotEnoughArgs;
import exceptions.WrongArgument;

import java.io.IOException;

/**
 * Base interface for commands
 */


public interface CommandInterface {
    public String getDescription();
    public String getName();
    public void execute(String[] args) throws IOException, NotEnoughArgs, WrongArgument;
}
