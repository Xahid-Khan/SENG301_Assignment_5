package uc.seng301.wordleapp.assignment5.command;

import uc.seng301.wordleapp.assignment5.guesser.ManualGuesser;

/**
 * A simple class which implements the Command Interface to undo and redo the guess.
 */
public class UndoCommand implements Command{

    private ManualGuesser receiver;

    public UndoCommand(ManualGuesser receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.undoAGuess();
    }
}
