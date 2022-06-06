package uc.seng301.wordleapp.assignment5.command;

/**
 * This class
 */
public class SetCommand {

    public SetCommand() {};

    public void executeCommand (Command command, String params) {
        if (params.equalsIgnoreCase("undo")) {
            command.execute();
        } else {
            command.undoExecute();
        }
    }




}
