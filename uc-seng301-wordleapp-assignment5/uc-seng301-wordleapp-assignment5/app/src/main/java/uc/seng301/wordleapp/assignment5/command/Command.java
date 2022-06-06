package uc.seng301.wordleapp.assignment5.command;

import uc.seng301.wordleapp.assignment5.dictionary.DictionaryResponse;

/**
 * This class exposes an interface to undo and redo a guess
 *
 */
public interface Command {

    /**
     * Undo a guess
     *
     * @Preconditions A guess has been made
     * @Postconditions A guess has been removed from the game guess made stack
     *
     */
    public void execute();


    /**
     * Redo a Guess
     * @Precondition A guess has been undone, and the undo tracking Stack is not empty
     * @Postcondition The guess is removed from the Stack that is tracking undone Guesses and added back to the guesses Stack
     */

    public void undoExecute();
}
