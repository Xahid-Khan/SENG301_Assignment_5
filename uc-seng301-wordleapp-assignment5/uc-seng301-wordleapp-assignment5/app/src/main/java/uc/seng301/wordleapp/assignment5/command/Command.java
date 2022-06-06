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
}
