package org.marsrover.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marsrover.Main;
import org.marsrover.constants.Direction;
import org.marsrover.exception.InvalidCoordinatesException;
import org.marsrover.exception.MarsRoverInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    public static Rover rover;

    public static int x=0;

    public static int y=0;

    @BeforeEach
    public void setSuccessRover() throws MarsRoverInputException {
         x = 1;
         y = 2;
        PlateauCoordinates.setTopRightCoordinates(5, 5);
        rover = new Rover();
    }

    @Test
    public void turnLeftTest() throws InvalidCoordinatesException {

        rover.setPosition(new Position(x, y, Direction.getOrientationByDirection(Direction.NORTH)));
        rover.turnLeft();
        assertEquals(Direction.WEST, Direction.getDirectionByOrientation(rover.getPosition().getOrientation()));
    }

    @Test
    public void turnRightTest() throws InvalidCoordinatesException {
        rover.setPosition(new Position(x, y, Direction.getOrientationByDirection(Direction.EAST)));
        rover.turnRight();
        assertEquals(Direction.SOUTH, Direction.getDirectionByOrientation(rover.getPosition().getOrientation()));
    }

    @Test
    public void moveForwardTest() throws InvalidCoordinatesException {
        rover.setPosition(new Position(x, y, Direction.getOrientationByDirection(Direction.NORTH)));
        rover.moveForward();
        assertEquals(y + 1, rover.getPosition().getY());
        assertEquals(Direction.NORTH, Direction.getDirectionByOrientation(rover.getPosition().getOrientation()));
    }

    @Test
    public void navigateRoverTest() throws InvalidCoordinatesException {
        final String commands = "LMLMLMLMM";
        rover.setPosition(new Position(x, y, Direction.getOrientationByDirection(Direction.NORTH)));
        rover.setCommands(commands);
        rover.navigateRover();
        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
        assertEquals(Direction.NORTH, Direction.getDirectionByOrientation(rover.getPosition().getOrientation()));
    }

}
