package uc.seng301.wordleapp.assignment5.command;

/**
 * This class set commands and invokes them
 */
public class SetCommand {

    public SetCommand() {};

    /**
     * This method receives a command and execute or undo it depending on the provided parameter.
     * @param command
     * @param params
     */
    public void executeCommand (Command command, String params) {
        if (params.equalsIgnoreCase("undo")) {
            command.execute();
        } else {
            command.undoExecute();
        }
    }




}
