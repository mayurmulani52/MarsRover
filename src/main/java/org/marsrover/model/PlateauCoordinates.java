package org.marsrover.model;


import org.marsrover.exception.InvalidCoordinatesException;

public class PlateauCoordinates {

    private static int top;

    private static int right;

    private static final int bottom=0;

    private static final int left=0;

    public static int getTop() {
        return top;
    }

    public static void setTop(int top) {
        PlateauCoordinates.top = top;
    }

    public static int getRight() {
        return right;
    }

    public static void setRight(int right) {
        PlateauCoordinates.right = right;
    }

    public static int getBottom() {
        return bottom;
    }


    public static int getLeft() {
        return left;
    }


    public static void setTopRightCoordinates(int top, int right) throws InvalidCoordinatesException {
        if (top < 0 || right < 0) {
            throw new InvalidCoordinatesException("Invalid co-ordinates(top=" + top + ", right=" + right + "). Requires Positive values only");
        }
        setTop(top);
        setRight(right);
    }

    public static void setPlateauCoordinates(String input) throws InvalidCoordinatesException{

        String[] inputCoordinates= input.split(" ");
        if (inputCoordinates.length != 2) {
            throw new InvalidCoordinatesException("Please input correct Plateau values!");
        }
        int top = Integer.parseInt(inputCoordinates[0]);
        int right = Integer.parseInt(inputCoordinates[1]);
        setTopRightCoordinates(top, right);
    }
}
