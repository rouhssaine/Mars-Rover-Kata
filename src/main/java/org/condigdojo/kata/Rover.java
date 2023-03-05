package org.condigdojo.kata;

public class Rover {

    char direction = 'N';

    public String execute(String commands) {
        commands.chars().forEach(c -> {
            if (direction == 'N') direction = 'E';
            else if (direction == 'E') direction = 'S';
            else if (direction == 'S') direction = 'W';
            else if (direction == 'W') direction = 'N';
        });
        return "0:0:" + direction;
    }

}
