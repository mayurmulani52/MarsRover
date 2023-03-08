package org.marsrover.constants;

import lombok.extern.slf4j.Slf4j;
import org.marsrover.exception.MarsRoverInputException;

import java.util.List;

@Slf4j
public final class Direction {
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    public static final String SOUTH = "S";

    public static final List<String> cardinalPoints = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    public static int getOrientationByDirection(String direction) {

        int orientation;

        switch (direction) {
            case "N" -> {
                return 0;
            }
            case "E" -> {
                return 1;
            }
            case "S" -> {
                return 2;
            }
            case "W" -> {
                return 3;
            }
            default -> {
                throw new MarsRoverInputException("Invalid Mars Rover Orientation captured");
            }
        }
    }

    public static String getDirectionByOrientation(int orientation) {

        String direction = "";

        switch (orientation) {
            case 0 -> {
                return "N";
            }
            case 1 -> {
                return "E";
            }
            case 2 -> {
                return "S";
            }
            case 3 -> {
                return "W";
            }
            default -> {
                throw new MarsRoverInputException("Invalid Mars Rover Direction captured");
            }
        }
    }
}