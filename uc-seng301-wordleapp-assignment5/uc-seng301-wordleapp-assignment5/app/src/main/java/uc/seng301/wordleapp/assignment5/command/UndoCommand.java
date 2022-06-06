package uc.seng301.wordleapp.assignment5.command;

import uc.seng301.wordleapp.assignment5.guesser.ManualGuesser;

/**
 * A simple class which implements the Command Interface to undo and redo the guess.
 */
public class UndoCommand implements Command{

    private ManualGuesser receiver;

    /**
     * A simple constructor that takes a Manual Guesser as a parameter and assign it to the local variable.
     * @param receiver
     */
    public UndoCommand(ManualGuesser receiver) {
        this.receiver = receiver;
    }

    /**
     * A method that will invoke the undo method available using the provided receiver.
     */
    @Override
    public void execute() {
        receiver.undoAGuess();
    }

    /**
     * This method will invoke the redo method available from the provided receiver.
     */
    @Override
    public void undoExecute() {
        receiver.redoAGuess();
    }
}
