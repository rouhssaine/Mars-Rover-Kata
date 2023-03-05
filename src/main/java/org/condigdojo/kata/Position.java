package org.condigdojo.kata;

import static org.condigdojo.kata.Direction.*;

public record Position(Coordinate coordinate, Direction direction) {

    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;

    public Position rotateRight() {
        return switch (this.direction) {
            case NORTH -> changeDirection(EAST);
            case EAST -> changeDirection(SOUTH);
            case SOUTH -> changeDirection(WEST);
            case WEST -> changeDirection(NORTH);
        };
    }

    public Position rotateLeft() {
        return switch (this.direction) {
            case NORTH -> changeDirection(WEST);
            case WEST -> changeDirection(SOUTH);
            case SOUTH -> changeDirection(EAST);
            case EAST -> changeDirection(NORTH);
        };
    }

    public Position move() {
        int x = this.coordinate.x();
        int y = this.coordinate.y();

        switch (this.direction) {
            case NORTH -> y = (y + 1) % MAX_HEIGHT;
            case EAST -> x = (x + 1) % MAX_WIDTH;
            case WEST -> x = (x > 0) ? x - 1 : MAX_WIDTH - 1;
            case SOUTH -> y = (y > 0) ? y - 1 : MAX_HEIGHT - 1;
        }

        return changeCoordinate(new Coordinate(x, y));
    }

    public String format() {
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }

    private Position changeDirection(Direction direction) {
        return new Position(this.coordinate, direction);
    }

    private Position changeCoordinate(Coordinate coordinate) {
        return new Position(coordinate, this.direction);
    }

}
