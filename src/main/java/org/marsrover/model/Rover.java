package org.marsrover.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.marsrover.constants.Direction;
import org.marsrover.exception.InvalidCoordinatesException;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Rover {

    private int roverId;

    private static int count;
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    private static final char MOVE = 'M';

    private Position position;

    private String commands;

    /**
     * Method to turn rover left from its current direction.
     */
    public void turnLeft() {
        int left = ((position.getOrientation() == 0) ? Direction.cardinalPoints.size() : position.getOrientation()) - 1;
        log.info("Rover[" + roverId + "] LEFT(" + Direction.cardinalPoints.get(position.getOrientation()) + ") -> " + Direction.cardinalPoints.get(left));
        position.setOrientation(left);
    }

    /**
     * Method to turn rover right from its current direction.
     */
    public void turnRight() {
        int right = (position.getOrientation() + 1) % Direction.cardinalPoints.size();
        log.info("Rover[" + roverId + "] RIGHT(" +Direction.cardinalPoints.get(position.getOrientation()) + ") -> " + Direction.cardinalPoints.get(right));
        position.setOrientation(right);
    }

    /**
     * Method to move rover one step forward.
     */
    public void moveForward() {
        log.info("Rover[" + roverId + "] MOVE FWD");
        switch (Direction.cardinalPoints.get(position.getOrientation())) {
            case Direction.NORTH:
                if (position.getY() < PlateauCoordinates.getTop()) {
                    position.setY(position.getY() + 1);
                }
                break;
            case Direction.EAST:
                if (position.getX() < PlateauCoordinates.getRight()) {
                    position.setX(position.getX() + 1);
                }
                break;
            case Direction.SOUTH:
                if (position.getY() > PlateauCoordinates.getBottom()) {
                    position.setY(position.getY() - 1);
                }
                break;
            case Direction.WEST:
                if (position.getX() > PlateauCoordinates.getLeft()) {
                    position.setX(position.getX() - 1);
                }
                break;
        }
    }


    /**
     * Method to navigate rover either left or right, or move forward.
     */
    public void startNavigation() {
        for (char command : getCommands().toCharArray()) {
            if (command == LEFT)
                turnLeft();
            else if (command == RIGHT)
                turnRight();
            else if (command == MOVE)
                moveForward();
        }
    }

    /**
     * Display rover's position.
     */
    public void displayPosition(final String prefix) {
        log.info("Rover[" + roverId + "] " + prefix + " POSITION X:" + position.getX() + " Y:" + position.getY() + " DIRECTION:");

    }


}