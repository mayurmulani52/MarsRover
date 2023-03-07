package org.marsrover.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    // Horizontal Position
    private int x;

    // Vertical Position
    private int y;

    // Direction of Robot's head, 0- NORTH, 1- EAST, 2- SOUTH, 3- WEST
    private int orientation;

}
