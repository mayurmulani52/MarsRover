package org.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marsrover.exception.MarsRoverInputException;
import org.marsrover.model.PlateauCoordinates;
import org.marsrover.model.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    public static final String plateauCoordinatesLine = "5 5";
    public static String roverPositionInput = "";
    public static String commandInput = "";

    public static Main main;

    public static Rover rover;

    @BeforeEach
    public void setSuccessRover() throws MarsRoverInputException {
        PlateauCoordinates.setPlateauCoordinates(plateauCoordinatesLine);
        roverPositionInput = "1 2 N";
        commandInput = "LMLMLMLMM";
        main = new Main();
        rover = main.initRover(roverPositionInput, commandInput);
    }

    @Test
    public void initRoverTest() throws MarsRoverInputException {
        assertEquals(0, rover.getPosition().getOrientation());
        assertEquals(1, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());
    }

    @Test
    public void getRoverPositionAfterNavigation() {
        rover.navigateRover();
        String roverNavigatedPosition = main.getRoverPositionAfterNavigation(rover);
        assertEquals("1 3 N", roverNavigatedPosition);
    }

    @Test
    public void initRoverWithMarsRoverInputException() throws  MarsRoverInputException{
        roverPositionInput= "123N";
        commandInput="sdfdsfdsf";
        Throwable throwable= assertThrows(MarsRoverInputException.class, () -> {
            rover = main.initRover(roverPositionInput, commandInput);
        });
        assertEquals(MarsRoverInputException.class, throwable.getClass());
        assertEquals("Please input correct values for the Rover position!", throwable.getMessage());
    }



}
