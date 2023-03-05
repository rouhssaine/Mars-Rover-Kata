package org.condigdojo.kata;

import java.util.Map;

import static org.condigdojo.kata.Rover.Direction.NORTH;

public class Rover {

    Direction direction = NORTH;
    Coordonate coordonate = new Coordonate(0, 0);

    public String execute(String commands) {
        commands.chars().forEach(c -> {
            if (c == 'R') direction = direction.rotateRight();
            if (c == 'L') direction = direction.rotateLeft();
            if (c == 'M') coordonate = coordonate.move(direction);
        });
        return coordonate.x + ":" + coordonate.y + ":" + direction.value;
    }

    record Coordonate(int x, int y) {

        public static final int MAX_HEIGHT = 10;
        public static final int MAX_WIDTH = 10;

        Coordonate move(Direction direction) {
            int x = this.x;
            int y = this.y;

            switch (direction) {
                case NORTH -> y = (y + 1) % MAX_HEIGHT;
                case EAST -> x = (x + 1) % MAX_WIDTH;
                case WEST -> x = (x > 0) ? x - 1 : MAX_WIDTH - 1;
                case SOUTH -> y = 9;
            }

            return new Coordonate(x, y);
        }

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
