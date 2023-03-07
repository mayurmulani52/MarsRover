package org.marsrover.model;


public class PlateauCoordinates {

    private static int top;

    private static int right;

    private static int bottom = 0;

    private static int left = 0;

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
}
