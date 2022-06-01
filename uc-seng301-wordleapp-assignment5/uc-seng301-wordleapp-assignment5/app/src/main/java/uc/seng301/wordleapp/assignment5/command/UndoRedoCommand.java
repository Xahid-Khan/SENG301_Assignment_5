package uc.seng301.wordleapp.assignment5.command;

import uc.seng301.wordleapp.assignment5.guesser.Guess;

import java.util.Stack;

/**
 * A simple class which implements the Command Interface to undo and redo the guess.
 */
public class UndoRedoCommand implements Command{

    private Stack<Guess> guesses;
    private Stack<Guess> redoStack;

    public UndoRedoCommand (Stack guesses, Stack redoStack) {
        this.guesses = guesses;
        this.redoStack = redoStack;
    }

    @Override
    public void execute() {
        Guess poppedGuess = null;
        if (!guesses.empty()) {
            redoStack.push(guesses.pop());
        }
    }

    @Override
    public void unExecute() {
        if (!redoStack.empty()) {
            guesses.push(redoStack.pop());
        }
    }
}
