package uc.seng301.wordleapp.assignment5.command;

public class SetCommand {

    private Command command;

    public SetCommand(Command command) {
        this.command = command;
    };

    public void executeCommand () {
        this.command.execute();
    }


}
