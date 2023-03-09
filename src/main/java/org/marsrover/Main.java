package org.marsrover;

import lombok.extern.slf4j.Slf4j;
import org.marsrover.constants.Direction;
import org.marsrover.exception.InvalidCoordinatesException;
import org.marsrover.exception.MarsRoverInputException;
import org.marsrover.model.PlateauCoordinates;
import org.marsrover.model.Position;
import org.marsrover.model.Rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class Main {

    public Rover initRover(String roverPositionInput, String commandInput) throws MarsRoverInputException {
        Rover rover = null;
        try {
            String[] roverPosition = roverPositionInput.split(" ");
            if (roverPosition.length != 3) {
                throw new MarsRoverInputException("Please input correct values for the Rover position!");
            }
            Integer orientation = Direction.getOrientationByDirection(roverPosition[2]);
            if (orientation == null) {
                throw new InvalidCoordinatesException("Invalid orientation \'" + orientation + "\'");
            }
            rover = new Rover();
            rover.setPosition(new Position(Integer.parseInt(roverPosition[0]), Integer.parseInt(roverPosition[1]), orientation.intValue()));
            rover.setRoverId(UUID.randomUUID().toString());
            rover.setCommands(commandInput);

        } catch (MarsRoverInputException me) {
            throw me;
        }

        return rover;

    }

    public void printNavigateRovers(List<Rover> roverList) {
        roverList.forEach(rover -> {
            rover.navigateRover();
            log.info("Rover[" + rover.getRoverId() + "] Final Position after series of commands: " + rover.getPosition().getX() + " " + rover.getPosition().getY() + " " +
                    Direction.getDirectionByOrientation(rover.getPosition().getOrientation()));
        });
    }

    public String getRoverPositionAfterNavigation(Rover rover) {
        String navigatedRoverPosition = "";

        navigatedRoverPosition = rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + Direction.getDirectionByOrientation(rover.getPosition().getOrientation());

        return navigatedRoverPosition;
    }

    public static void main(String[] args) throws IOException {

        log.info("Please input the coordinates of the Plateau! Make sure its positive values only! for e.g: 2 2");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        PlateauCoordinates.setPlateauCoordinates(firstLine);
        Main main = new Main();
        List<Rover> roverList = new ArrayList<Rover>();
        try {
            // taking two rover inputs for the deployment. It can be increased as per the need
            for (int i = 0; i < 2; i++) {
                Rover rover = null;
                log.info("Please input the Rover Position split by Space! for e.g: 1 2 N");
                String roverPositionLine = br.readLine();
                log.info("Please input commands to Rover without Space! for e.g: LMLMLMLMM");
                String commandInputLine = br.readLine();
                rover = main.initRover(roverPositionLine, commandInputLine);
                roverList.add(rover);
            }
            br.close();
            main.printNavigateRovers(roverList);
        } catch (MarsRoverInputException me) {
            log.error("Error: ", me);
        }
    }
}