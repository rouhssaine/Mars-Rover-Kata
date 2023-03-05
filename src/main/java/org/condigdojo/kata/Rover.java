package org.condigdojo.kata;

public class Rover {

    char direction = 'N';

    public String execute(String commands) {
        commands.chars().forEach(c -> {
            if (direction == 'S') direction = 'W';
            if (direction == 'E') direction = 'S';
            if (direction == 'N') direction = 'E';
        });
        return "0:0:" + direction;
    }

}
