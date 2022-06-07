# SENG301 Assignment 5 (2022) - Student answers

**Zahid Khan**

## Task 1 - Identify the patterns in the code

### Pattern 1

#### What pattern is it?

Strategy Pattern

#### What is its goal in the code?

Strategy defines the family of algorithms, encapsulate each one, and make them interchangeable. As we can see in the provided
code base, that we have three different implementations of getGuess() method in each subclass of Guesser, so we have three
different strategies that player/user can choose to play with. The algorithms of each subclass can change independently.
The purpose of the code is to provide user/player with multiple algorithm options.

#### Name of UML Class diagram attached:

Strategy Method.png

#### Mapping to GoF pattern elements:

| GoF element       | Code element  |
|-------------------|---------------|
| Context           | Game          |
| Strategy          | Guesser       |
| ConcreteStrategyA | SmartGuesser  |
| ConcreteStrategyB | RandomGuesser |
| ConcreteStrategyC | ManualGuesser |
| Algorithm         | getGuess()    |


### Pattern 2

#### What pattern is it?

Proxy Pattern

#### What is its goal in the code?

Proxy pattern has many uses, it can be used as a placeholder or middle man between classes to increase security. In this 
code the Dictionary class is a proxy class which access the DictionaryService class and performs the guessWord service. But
the code doesn't use the proxy class it accesses the service directly, so the proxy service and additional layer of security
is not utilised. The purpose of the code is to get help from online wordle solver to solve the guess. 

#### Name of UML Class diagram attached:

Proxy Method.png

#### Mapping to GoF pattern elements:

| GoF element  | Code element      |
|--------------|-------------------|
| Subject      | DictionaryQuery   |
| Proxy        | Dictionary        |
| Real Subject | DictionaryService |
| request()    | guessWord(String) |


## Task 2 - Full UML Class diagram

### Name of file of full UML Class diagram attached

Retro-document-design.png

## Task 3 - Implement new feature

### What pattern fulfils the need for the feature?

Command Pattern

### What is its goal and why is it needed here?

Command pattern encapsulates a request as an object, which help us decouple the request sender from request receiver, 
this pattern also support undoable operations. By using the command pattern we can create independent command objects
which can carry out the undo and redo actions, and it can execute requests at different times. It fits perfectly with
provided code base to separate the request sender and receiver and allow us to encapsulate methods into stand-alone 
objects which can be parameterised. 

### Name of UML Class diagram attached:

Command Pattern.png

### Mapping to GoF pattern elements:

| GoF element     | Code element  |
|-----------------|---------------|
| Command         | Command       |
| ConcreteCommand | UndoCommand   |
| Receiver        | ManualGuesser |
| Invoker         | SetCommand    |
| Client          | Game          |


## Task 4 - BONUS - Acceptance tests for Task 4

### Feature file (Cucumber Scenarios)

u5-undo-redo-guess.feature

### Java class implementing the acceptance tests

UndoRedoGuessFeature
