# The Hungry Snake

### Introduction
The objective of the game is to direct the snake to consume the food and try to make it grow as long as possible to maximise the score. The program is coded on java and Jframe extension is also used. 
> The aim of this project was to use the Oops principles and write a very efficient code for the above problem statement. 

## Formal Game Description
A interactive GUI based game, with the objective that the user should collect the food items as much as possible to increase the score obtained. As more food is collected, the snake grows  in length making in harder to manuver it thus increasing the chances of hitting itself or the boundary. It invokes the players creativity to decide the most optimum path to reach the target food without losing to the constraints.

### Installation
- unzip the entire project directory and open the file system in your prefered text editor
- java.lang package must be installed on system
- since we are using JFrame, it should be imported along with java.
- in the GameBoard class make sure you reset the file path appropriately in following lines of code. <br>
``
ImageIcon iid = new ImageIcon("code_files/src/game/dot.png"); `` <br>  ``
ImageIcon iia = new ImageIcon("code_files/src/game/apple.png"); `` <br> ``
ImageIcon iih = new ImageIcon("code_files/src/game/head.png"); ``<br>

### Game Featues
- Snake is allowed to move in four cardinal directions
- Snake length increases on eating the food
- Game is over when snake crosses itself or boundary
- after every given interval of time food is generated   
- Players can login/signup. 
- Then, allow players to start with choosing board size and difficulty level.
- Develop a simple scoring mechanism based on game time and difficulty level, and add to the player's score for a specific board size.
- Finally, our application should be able to print the leaderboard containing ranking statistics for a specific board size.
- The initial login/signup and game is designed by GUI interface.


### Ooop concepts used

#### Observer Design Patterns (still pending)

- The inputs in our code include snake direction input, time instant of action and gameOver status, these are actively interacting with GameBoard. GameBoard responds to GameAdmin which in turn displays the output to GUI.
- An example of when the inputs would directly reflect in its dependencies: snake direction causes the snake to hit wall causing the GAME OVER GUI to be implemented, gameOver status to be changed to 'true' and the timer to be stopped.
- The direction change might cause the snake to consume an apple and grow one in length, which in turn updates a different set of dependencies.


### Forms of improvements
- powerups can be added
    - for consuming multiple food within a small time, bonus point can be given to the score. Also speed of the snake can be reduced as a reward.
    - powerups like freeze (temporarily slow the snake speed), frenzy (make multiply food appear simultaneously for a small time and bonus points for eat food consumed), invisible (make the snake invisible for a small time), teleport (make the snake teleport from one boundary to another temporarily)
    - some powerup can be used to increase the board size.
- Implement the comparable interface on the Player class  so that Leaderboard can return a sorted list.
- a password checker can be implemented to check if the passwords each users use are strong enough.
- when a new user is signing up, make sure the new userID created is not same the existing ones.
