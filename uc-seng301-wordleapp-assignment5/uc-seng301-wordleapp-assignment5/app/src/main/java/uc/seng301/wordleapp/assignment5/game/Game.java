package uc.seng301.wordleapp.assignment5.game;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uc.seng301.wordleapp.assignment5.command.*;
import uc.seng301.wordleapp.assignment5.guesser.Guess;
import uc.seng301.wordleapp.assignment5.guesser.Guesser;
import uc.seng301.wordleapp.assignment5.guesser.ManualGuesser;
import uc.seng301.wordleapp.assignment5.model.GameRecord;
import uc.seng301.wordleapp.assignment5.model.User;

/**
 * Plays a singular Wordle game creating a GameRecord of the output
 */
public class Game {
    private static final Logger LOGGER = LogManager.getLogger(Game.class);
    private final User user;
    private final Guesser guesser;
    private final Wordle wordle;

    private final SetCommand setCommand;

    /**
     * Default constructor
     *
     * @param user    a user (assumed not null)
     * @param guesser the guesser that plays the wordle (assumed not null)
     * @param wordle  the wordle to play the game with (assumed not null)
     */
    public Game(User user, Guesser guesser, Wordle wordle) {
        this.user = user;
        this.guesser = guesser;
        this.wordle = wordle;
        this.setCommand = new SetCommand();
    }

    /**
     * Plays a game of Wordle with the given User, Guesser, and Wordle.
     * Repeats asking for guesses until complete or a quit condition is met
     * Will return null at any point if the guesser stops providing guesses,
     * assuming an exit condition is met
     *
     * @return Gamerecord representation of the game
     */
    public GameRecord playGame() {
        LOGGER.info("Playing game with word '{}'", wordle.getWord());
        boolean gameWon = false;
        while (!gameWon) {
            Guess guess = guesser.getGuess();
            LOGGER.info("Guessing: {}", guess);
            if (guess == null) {
                return null;
            }
            if (guess.getProposition().equalsIgnoreCase("undo") ||
                guess.getProposition().equalsIgnoreCase("redo")) {
                Command undoCommand = new UndoCommand((ManualGuesser) guesser);
                setCommand.executeCommand(undoCommand, guess.getProposition());
            } else {
                gameWon = guess.isCorrect();
            }
        }
        LOGGER.info("Game completed with {} guesses", guesser.getNumGuesses());
        GameRecord gameRecord = new GameRecord();
        gameRecord.setWord(wordle.getWord());
        gameRecord.setUser(user);
        gameRecord.setNumGuesses(guesser.getNumGuesses());
        gameRecord.setTimestamp(new Date());
        return gameRecord;
    }
}
