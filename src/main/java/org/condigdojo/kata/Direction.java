package org.condigdojo.kata;

public enum Direction {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
