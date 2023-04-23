package commands;

/**
 * Base interface for commands
 */


public interface CommandInterface {
    public String getDescription();
    public String getName();
    public void execute(String[] args);
}
