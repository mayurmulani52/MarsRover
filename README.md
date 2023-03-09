
### MARS ROVERS Technical Challenge

A squad of robotic rovers are to be landed by NASA on a plateau on Mars.

This plateau, which is curiously rectangular, must be navigated by the rovers so that their onboard cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover's position is represented by a combination of an x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

To control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right, respectively, without moving from its current spot.

'M' means move forward one grid point and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

### Input:

The first line of input is the upper-right coordinates of the plateau. The lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

### Output:

The output for each rover should be its final coordinates and heading.

Test Input:

5 5

1 2 N

LMLMLMLMM

3 3 E

MMRMMRMRRM

Expected Output:

1 3 N

5 1 E

### Solution:

Mars Rover application is designed and developed using Java17 as a Programming language and Gradle as a build tool. Application can be run by passing the command line arguments. First line of the input would be Plateau coordinates and after which 2 more lines would be required to plot the direction & orientation along with commands to the rover. 

Unit test cases are available under test path.

Solution has been designed considering first quadrant of the plateau and Rovers will be deployed sequentially. Based on the different commands like L for Left, R for Right, M for Move forward, Rovers will be navigated. Orienation defined considering N for North=0, E for East=1, S for South=2, W for West=3. TurnLeft will be decreasing orientation number by 1, for an example lets say if Rover head is facing East direction and adter the command of LeftTurn, Rover Head will be moved to North facing direction. Which means orientation from 1 (For EAST) will become 0 for NORTH. 

Turn Right meaning, Orientation will be increased and number range is [0, 1, 2, 3]. Once Orientation reached 3 number then turnRight command will change the value of orientation to 0.

Move Forward meaning, Rover will move one step forward to the Rover Head direction.

#### Command Codes:
L=> Left Turn
R=> Right Turn
M=> Move Forward.

#### Rover Position:
x=> Horizontal digit to plot the plateau
y=> Vertical digit to plot the plateau
N,S,W,E => Orientation direction to define Rover head position facing direction.

#### Orientation:
N=>0
E=>1
S=>2
W=>3

Note: Please do note that for this program, only +ve values need to be passed for plateau coordinates. Rovers always will be navigating inside the boundary of Plateau.

