package org.marsrover.model;

import org.junit.jupiter.api.Test;
import org.marsrover.exception.InvalidCoordinatesException;
import org.marsrover.exception.MarsRoverInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlateauCoordinatesTest {

    @Test
    public void setPlateauCoordinatesTest() throws InvalidCoordinatesException{
        String plateauCoordinates= "5 5";
        PlateauCoordinates.setPlateauCoordinates(plateauCoordinates);
        assertEquals(5, PlateauCoordinates.getTop());
        assertEquals(5, PlateauCoordinates.getRight());
    }

    @Test
    public void setPlateauCoordinatesInvalidCoordinatesException() throws InvalidCoordinatesException {

        String plateauCoordinates= "sdfsf";
        Throwable throwable= assertThrows(InvalidCoordinatesException.class, () -> {
            PlateauCoordinates.setPlateauCoordinates(plateauCoordinates);
        });
        assertEquals(InvalidCoordinatesException.class, throwable.getClass());
        assertEquals("Please input correct Plateau values!", throwable.getMessage());
    }

    @Test
    public void setTopRightCoordinatesInvalidExceptionTest() throws InvalidCoordinatesException{

        int top= -5;
        int right= -5;

        Throwable throwable= assertThrows(InvalidCoordinatesException.class, () -> {
            PlateauCoordinates.setTopRightCoordinates(top, right);
        });
        assertEquals(InvalidCoordinatesException.class, throwable.getClass());
        assertEquals("Invalid co-ordinates(top=" + top + ", right=" + right + "). Requires Positive values only", throwable.getMessage());
    }
}
