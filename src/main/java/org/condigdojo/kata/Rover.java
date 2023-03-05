package org.condigdojo.kata;

import java.util.Map;

import static org.condigdojo.kata.Rover.Direction.NORTH;

public class Rover {

    Direction direction = NORTH;
    int x, y = 0;

    public String execute(String commands) {
        commands.chars().forEach(c -> {
            if (c == 'R') direction = direction.rotateRight();
            if (c == 'L') direction = direction.rotateLeft();
            if (c == 'M') move();
        });
        return x + ":" + y + ":" + direction.value;
    }

    private void move() {
        y += 1;
    }

    enum Direction {
        NORTH("N"),
        EAST("E"),
        SOUTH("S"),
        WEST("W");

        private final String value;

        Direction(String value) {
            this.value = value;
        }

        public Direction rotateRight() {
            var rightMap = Map.of(
                    NORTH, EAST,
                    EAST, SOUTH,
                    SOUTH, WEST,
                    WEST, NORTH);
            return rightMap.get(this);
        }

        public Direction rotateLeft() {
            var leftMap = Map.of(
                    NORTH, WEST,
                    WEST, SOUTH,
                    SOUTH, EAST,
                    EAST, NORTH);
            return leftMap.get(this);
        }
    }

}
