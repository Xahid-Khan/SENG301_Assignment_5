package uc.seng301.wordleapp.assignment5.command;

import uc.seng301.wordleapp.assignment5.guesser.ManualGuesser;

public class RedoCommand implements Command{
    private ManualGuesser receiver;

    public RedoCommand (ManualGuesser receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute () {
        receiver.redoAGuess();
    }
}
