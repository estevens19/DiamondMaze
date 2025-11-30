## LDTS_t13g05 - Diamond Maze

> A knight finds himself lost in a labyrinth that seems to have no end. He needs to find the secret key to escape through the gate.

> ⁠The time limit must be taken into account. Scattered throughout the map, there are items that increase this time limit. If the player fails to open the portal within the time limit, the level restarts.
⁠To achieve a higher score, the player needs to collect the diamonds randomly distributed throughout the map.
To capture the key, the player must discover which of the diamonds holds the key.
⁠To make the game more difficult, there are guards scattered throughout the map. If an guard catches the player, the level restarts.

> 	⁠This project was developed by *Ricardo Estevéns* ([up202405321@up.pt](mailto:up202405321@up.pt)), *Gustavo Oliveira* ([up202205770@up.pt](mailto:up202205770@up.pt)), and *Rogério Barbosa* ([up202406902@up.pt](mailto:up202406902@up.pt)) for LDTS 2025/26.


### IMPLEMENTED FEATURE

- *Knight* - The game's character.
- *Guards* - Scattered throughout the map.
- *Time* - There is a timer to complete the level.
- *Key* - It will be hidden in a diamond. It is used to open the portal.
- *Diamonds* - Located in random places on the map.
- ⁠*Gate* - Allows you to proceed to the next level.
- ⁠*Maze* - Limits the movement area within the map.
- ⁠*Movement* - Using the arrow keys (up, down, left, and right).
<br>

- *Main Menu*
<img width="1862" height="1048" alt="Mockup 1" src="https://github.com/user-attachments/assets/89a0d485-e3da-4746-8e51-30a9ea5562e6" />

- *Levels Menu*
<img width="1862" height="1048" alt="Mockup 2" src="https://github.com/user-attachments/assets/6a97a074-3c0e-464e-be4b-f4bb2c813230" />

- *Level 1*
<img width="1862" height="1048" alt="Mockup 3" src="https://github.com/user-attachments/assets/631a92b8-3863-49b1-aa78-ff3f097872cf" />


### PLANNED FEATURES

- *Score* - It will be crucial for being able to open the portal (minimum score).
- ⁠*Potions* - They can have either a positive or negative effect on the level.
- ⁠*Unveiling the map* - The player will have to walk around the map to reveal it.

### DESIGN

<img width="5728" height="1789" alt="UML" src="https://github.com/user-attachments/assets/c8c3ed52-e6c2-4a50-8a87-bfcae97636bc" />

*Problem in Context.*

To improve code organization, we needed a design approach that would allow us to implement a better *separation of concerns* for each game object. The core problem was the *excessive interdependence* between the game's logic, visual presentation, and user input handling.

*The Pattern*

We implemented the *MVC (Model-View-Controller) Architectural Pattern*. This pattern organizes the code into three distinct components:

- ⁠*Model*: Responsible for the entities in the game, such as MenuMain, MenuLevels, and the Maze for each level.
- ⁠*View*: Handles rendering the current state of the game—for example, MazeViewer draws the maze for each level, and MenuMainViewer renders the main menu.
- ⁠*Controller*: Manages state transitions based on user input and updates the Model accordingly, as seen in KnightController, which controls the knight’s movement within the maze.

This structure ensures a clear separation of concerns, improving both maintainability and scalability.

*Implementation*

UML reprensentation showing above.

*Consequences.* 

Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

- *Enhanced Maintainability:* Changes to the GUI can be made without touching the game logic (Model). For instance, changing the knight's sprite is now isolated to the ⁠ KnightViewer ⁠ class.
- ⁠*Improved Testability:* The Model can be tested in isolation with unit tests, as it has no dependencies on the View or Controller. For example, we can write tests for ⁠ knight.move() ⁠ without testing into the game.
- ⁠*Parallel Development:* The clear boundaries allow one developer to work on the ⁠ Maze ⁠ logic (Model) while another works on the ⁠ MazeViewer ⁠ (View), with minimal conflict.
- ⁠*Clarity and Structure:* The code is now organized according to a well-known pattern, making it instantly more understandable to new developers joining the project.

*Problem in Context.*

The game currently uses extensive conditional logic within different Game objects:

The menu navigation relies on numerous conditional statements to determine which button is selected and what happens when buttons are pressed. 

For the state of Maze we need an approach to control the flow of the Game, for Characters and Elements.

*The Pattern*

We implemented the *State Pattern* to encapsulate state-specific behavior into dedicated classes. This pattern provides a structured approach to managing state-dependent behavior.

State changes become clear, explicit operations rather than implicit side effects of conditional logic.

New states can be added without modifying existing state logic, following the Open/Closed Principle.

*Implementation*

[GameState] [https://github.com/FEUPLDTS2025/projectt13g05/blob/main/src/main/java/org/example/state/GameState.java](https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/GameState.java)

[MenuLevelsState] [https://github.com/FEUP-LDTS 2025/projectt13g05/blob/main/src/main/java/org/example/state/MenuLevelsState.java](https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/MenuLevelsState.java)

[MenuMainState] https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/MenuMainState.java

[State] [https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/State.java](https://github.com/FEUP-LDTS-2025/project-t13g05/blob/main/src/main/java/org/example/state/MenuMainState.java)

*Consequences.* 

The use of the State Pattern in the current design allows the following benefits:

- ⁠*Improve Code Readability:* The several states that represent the Maze changes with different stages of the Game become more explicit in the code.
- ⁠*State Management:* The implementation now involves a greater number of classes and instances, but this added structure *significantly simplifies overall management and scalability*.

*Problem in Context.*

To address the complexity inherent in Maze implementations containing numerous diverse components, a approach was required to enable more organized and maintainable Maze creation.

*The Pattern*

We implemented the *Builder Pattern.* It’s primarily used to address challenges related to *creating complex objects* that have numerous parameters, particularly when many of these parameters are optional or require step-by-step construction.

*Implementation*

[LoaderMazeBuilder]
[https://github.com/FEUPLDTS2025/projectt13g05/blob/main/src/main/java/org/example/model/game/maze/LoaderMazeBuilder.java](https://github.com/FEUP-LDTS2025/projectt13g05/blob/main/src/main/java/org/example/model/game/maze/LoaderMazeBuilder.java)

[MazeBuilder]
[https://github.com/FEUPLDTS2025/projectt13g05/blob/main/src/main/java/org/example/model/game/maze/MazeBuilder.java](https://github.com/FEUP-LDTS-2025/projectt13g05/blob/main/src/main/java/org/example/model/game/maze/LoaderMazeBuilder.java)

*Consequences.* 

The use of the *Builder Pattern* in the current Maze design allows for the following key benefits:

- *Encapsulated Construction Logic:* It encapsulates the complex algorithm for creating a maze (like generating guards, knight and elements). The client code doesn't need to know how a maze is assembled, it only specifies what it wants.
- ⁠*Step-by-Step Construction:* It allows the maze to be constructed step-by-step. The ⁠ MazeBuilder ⁠ can first create Maze and ⁠ LoaderMazeBuilder ⁠ populate the ⁠ Maze ⁠ with characters and elements, all within a single controlled process.
- ⁠*Validation and Consistency:* This ensures that every ⁠ Maze ⁠ object is in a consistent and valid state upon creation.
- ⁠*Separation of Concerns:* It separates the code for constructing a maze from the ⁠ Maze ⁠ class itself. The ⁠ Maze ⁠ class can remain focused on its core responsibility representing the maze structure and providing an interface for navigation and interaction.

### SELF-EVALUATION

- ⁠Gustavo Oliveira: 34%
- ⁠Ricardo Estevéns: 33%
- ⁠Rogério Barbosa: 33%
