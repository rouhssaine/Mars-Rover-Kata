package org.condigdojo.kata;

public class Rover {

    char direction = 'N';

    public String execute(String commands) {
        commands.chars().forEach(c -> {
            if(c == 'R') direction = rotateRight();
            if(c == 'L') direction = rotateLeft();
        });
        return "0:0:" + direction;
    }

    private char rotateRight() {
        if (direction == 'N') return 'E';
        else if (direction == 'E') return 'S';
        else if (direction == 'S') return 'W';
        else if (direction == 'W') return 'N';
        return direction;
    }

    private char rotateLeft() {
        if (direction == 'N') return 'W';
        return direction;
    }

}
