Feature: U5 - Manual player can undo and redo guesses

  Scenario: AC1 - An undone guess is removed from my guesses
    Given I am playing the game with manual guesser
    When I make following guesses "tells", "walks", "heard", "fully", "undo", "undo", "undo", "redo", "redo"
    Then stack will only have "tells", "walks", "heard" after undo

  Scenario: AC2 - The number of guesses is decreased by one when I (player) undo a guess
    Given I am playing the game with manual guesser
    When I make following guesses "sully", "which", "beats", "tully", "bully", "start", "undo", "undo", "undo"
    Then the number of guesses made is 3
#
  Scenario: AC3 - I (Player) can redo a guess only if I have undone a guess
    Given I am playing the game with manual guesser
    When I make following guesses "talks", "mocks", "walks", "docks", "locks", "lucky", "sully", "molly", "redo"
    Then There will be an error message "There is no Guess to Redo"

  Scenario: AC4 - When I (player) redo a guess, the undo guess is re-added to the stack of guesses
    Given I am playing the game with manual guesser
    When I make following guesses "fully", "wools", "beats", "wolfs", "undo", "undo", "undo", "redo", "redo"
    Then stack will only have "fully", "wools", "beats" after redo

  Scenario: AC5 - I can redo all my guesses in reverse order I made the guesses
    Given I am playing the game with manual guesser
    When I make following guesses "meets", "beats", "gully", "undo", "undo", "undo", "redo", "redo", "redo"
    Then stack will only have "meets", "beats", "gully" after performing few undo and redo