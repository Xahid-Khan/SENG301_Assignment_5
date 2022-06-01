# SENG301 Assignment 5 (2022) - Student answers

**YOUR NAME**

## Task 1 - Identify the patterns in the code

### Pattern 1

#### What pattern is it?

Template Pattern/Method

#### What is its goal in the code?

Guesser is an abstract class which provide skeleton for concrete classes like ManualGuesser, SmartGuesser, and RandomGuesser.
The skeleton acts as a guideline to subclasses allowing them to change without changing the structure of the code.
In the code the abstract Guesser class provide an abstract method getGuess() which is implemented by the subclass, and a
getNumGuesses() method which is available to all the subclasses to use. Concrete classes like SmartGuesser and RandomGuesser
than override the skeleton code.

#### Name of UML Class diagram attached:

TemplateMethod.png

#### Mapping to GoF pattern elements:

| GoF element    | Code element  |
|----------------|---------------|
| Abstract Class | Guesser       |
| Concrete Class | RandomGuesser |
| Concrete Class | SmartGuesser  |
| Concrete Class | ManualGuesser |


### Pattern 2

#### What pattern is it?

Proxy

#### What is its goal in the code?



#### Name of UML Class diagram attached:

**YOUR ANSWER**

#### Mapping to GoF pattern elements:

| GoF element  | Code element      |
|--------------|-------------------|
| Client       | App               |
| Subject      | DictionaryQuery   |
| Proxy        | Dictionary        |
| Real Subject | DictionaryService |


## Task 2 - Full UML Class diagram



### Name of file of full UML Class diagram attached

**YOUR ANSWER**


## Task 3 - Implement new feature

### What pattern fulfils the need for the feature?

**YOUR ANSWER**

### What is its goal and why is it needed here?

**YOUR ANSWER**

### Name of UML Class diagram attached:

**YOUR ANSWER**

### Mapping to GoF pattern elements:

| GoF element | Code element |
| ----------- | ------------ |
|             |              |


## Task 4 - BONUS - Acceptance tests for Task 4

### Feature file (Cucumber Scenarios)

**NAME OF FEATURE FILE**

### Java class implementing the acceptance tests

**NAME OF JAVA FILE**
