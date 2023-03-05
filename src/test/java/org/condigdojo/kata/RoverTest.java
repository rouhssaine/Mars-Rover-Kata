package org.condigdojo.kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class RoverTest {

    private Rover rover;

    @Test
    void should_rotate_right() {
        //GIVEN
        rover = new Rover();

        //WHEN
        var result = rover.execute("R");

        //THEN
        assertThat(result).isEqualTo("0:0:E");
    }

}
