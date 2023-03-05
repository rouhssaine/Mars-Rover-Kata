package org.condigdojo.kata;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rover {

    private Position position;

    public String execute(String commands) {
        commands.chars().forEach(c -> {
            if (c == 'R') position = position.rotateRight();
            if (c == 'L') position = position.rotateLeft();
            if (c == 'M') position = position.move();
        });
        return position.format();
    }

}
