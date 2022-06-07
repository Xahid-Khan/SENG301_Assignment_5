package gradle.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import uc.seng301.wordleapp.assignment5.game.Game;
import uc.seng301.wordleapp.assignment5.game.Wordle;
import uc.seng301.wordleapp.assignment5.guesser.Guess;
import uc.seng301.wordleapp.assignment5.guesser.ManualGuesser;
import uc.seng301.wordleapp.assignment5.model.User;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.mockito.Mockito.when;

public class UndoRedoGuessFeature {
    private Wordle wordle;
    private Scanner scanner;
    private OutputStream outputStream;
    private PrintStream printStream;
    private Queue<String> mockInputs;
    private User user;
    private ManualGuesser guesser;
    private Game game;
    private Stack<Guess> currentGuesses;
    private int numOfGuesses;

    @Before
    public void setup() {
        wordle = new Wordle("gully");
        user = new User();

        scanner = Mockito.mock(Scanner.class);
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        mockInputs = new LinkedList<>();

        Answer<String> customAnswer = new Answer() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return mockInputs.remove();
            }
        };

        when(scanner.nextLine()).thenAnswer(customAnswer);
    }

    /**
     * A simple helper function for adding any number of string inputs to the mocked scanner
     * The underlying structure is a Queue so follows FIFO rules
     * @param mockedInputs any number of string parameters to add in order
     */
    private void addScannerMocking(String... mockedInputs) {
        mockInputs.addAll(Arrays.asList(mockedInputs));
    }

    @Given("I am playing the game with manual guesser")
    public void i_am_playing_the_game_with_manual_guesser() {
        guesser = new ManualGuesser(wordle, scanner, printStream);
        game = new Game(user, guesser, wordle);
        currentGuesses = new Stack<>();
    }

    @When("I make following guesses {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_make_following_guesses(String guess1, String guess2, String guess3, String guess4, String guess5, String guess6, String guess7, String guess8, String guess9) {
        addScannerMocking(guess1, guess2, guess3, guess4, guess5, guess6, guess7, guess8, guess9, "!q");
        game.playGame();
        currentGuesses = guesser.getGuesses();
        numOfGuesses = guesser.getNumGuesses();
    }

    @Then("stack will only have {string}, {string}, {string} after undo")
    public void stack_will_only_have_after_undo(String guess1, String guess2, String guess3) {
        Assertions.assertNotNull(currentGuesses);
        Assertions.assertEquals(3, currentGuesses.size());

        Assertions.assertEquals(guess1, currentGuesses.get(0).getProposition());
        Assertions.assertEquals(guess2, currentGuesses.get(1).getProposition());
        Assertions.assertEquals(guess3, currentGuesses.get(2).getProposition());
    }

    @Then("the number of guesses made is {int}")
    public void the_number_of_guesses_made_is(Integer number) {
        Assertions.assertEquals(3, currentGuesses.size());
        Assertions.assertNotNull(numOfGuesses);
        Assertions.assertEquals(number, numOfGuesses);
    }

    @Then("There will be an error message {string}")
    public void there_will_be_an_error_message(String errorMessage) {
        Assertions.assertEquals(8, currentGuesses.size());
        printStream.flush();
        Assertions.assertTrue(
        outputStream.toString().contains(errorMessage)
        );
    }

    @Then("stack will only have {string}, {string}, {string} after redo")
    public void stack_will_only_have_after_redo(String guess1, String guess2, String guess3) {
        Assertions.assertNotNull(currentGuesses);
        Assertions.assertEquals(3, currentGuesses.size());

        Assertions.assertEquals(guess1, currentGuesses.get(0).getProposition());
        Assertions.assertEquals(guess2, currentGuesses.get(1).getProposition());
        Assertions.assertEquals(guess3, currentGuesses.get(2).getProposition());
    }

    @Then("stack will only have {string}, {string}, {string} after performing few undo and redo")
    public void stack_will_only_have_after_performing_few_undo_and_redo(String guess1, String guess2, String guess3) {
        Assertions.assertNotNull(currentGuesses);
        Stack<String> temp = new Stack<>();
        temp.push("beats");
        temp.push("gully");
        temp.push("talks");

//        Assertions.assertEquals(temp, currentGuesses);
        Assertions.assertEquals(3, currentGuesses.size());

        Assertions.assertEquals(guess1, currentGuesses.get(0).getProposition());
        Assertions.assertEquals(guess2, currentGuesses.get(1).getProposition());
        Assertions.assertEquals(guess3, currentGuesses.get(2).getProposition());
    }

}
