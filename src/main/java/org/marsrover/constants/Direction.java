package org.marsrover.constants;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public final class Direction {
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    public static final String SOUTH = "S";

    public static final List<String> cardinalPoints = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    public static Map<String, Integer> cardinalPointsMap = null;

    static {
        cardinalPointsMap= IntStream.range(0, cardinalPoints.size()).boxed().collect(Collectors.toMap( i -> cardinalPoints.get(i),i -> i));
    }
}