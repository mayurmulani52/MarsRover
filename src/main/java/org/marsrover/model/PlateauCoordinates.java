package org.marsrover.model;


import org.marsrover.exception.InvalidCoordinatesException;

public class PlateauCoordinates {

    private static int top;

    private static int right;

    private static int bottom;

    private static int left;

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

    public static void setBottom(int bottom) {
        PlateauCoordinates.bottom = bottom;
    }

    public static int getLeft() {
        return left;
    }

    public static void setLeft(int left) {
        PlateauCoordinates.left = left;
    }

    public static void setTopRightCoordinates(int top, int right) throws InvalidCoordinatesException {
        if(top < 0 || right < 0) {
            throw new InvalidCoordinatesException("Invalid co-ordinates(top=" + top + ", right=" + right + "). Requires Positive values only");
        }
        setTop(top);
        setRight(right);
    }

}
