package org.condigdojo.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class RoverTest {

    private Rover rover;

    @BeforeEach
    void setup() {
        rover = new Rover();
    }

    @ParameterizedTest(name = "should return {1} when execute {0}")
    @CsvSource(value = {
            "R -> 0:0:E",
            "RR -> 0:0:S",
            "RRR -> 0:0:W",
            "RRRR -> 0:0:N"
    }, delimiterString = " -> ")
    void should_rotate_right(String commands, String expected) {
        assertThat(rover.execute(commands)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "should return {1} when execute {0}")
    @CsvSource(value = {
            "L -> 0:0:W",
            "LL -> 0:0:S",
            "LLL -> 0:0:E",
            "LLLL -> 0:0:N",
    }, delimiterString = " -> ")
    void should_rotate_left(String commands, String expected) {
        assertThat(rover.execute(commands)).isEqualTo(expected);
    }

}
