package ch.houseoftest.assessment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsTest1 {

    RockPaperScissors game = new RockPaperScissors();

    @Test
    void testMoveBeats() {
        assertTrue(Move.ROCK.beats(Move.SCISSORS));
        assertTrue(Move.PAPER.beats(Move.ROCK));
        assertTrue(Move.SCISSORS.beats(Move.PAPER));

        assertFalse(Move.ROCK.beats(Move.PAPER));
        assertFalse(Move.PAPER.beats(Move.SCISSORS));
        assertFalse(Move.SCISSORS.beats(Move.ROCK));

        assertFalse(Move.ROCK.beats(Move.ROCK));
        assertFalse(Move.PAPER.beats(Move.PAPER));
        assertFalse(Move.SCISSORS.beats(Move.SCISSORS));
    }

    @Test
    void testDetermineWinner_Tie() {
        assertEquals("It's a tie!", game.determineWinner(Move.ROCK, Move.ROCK));
        assertEquals("It's a tie!", game.determineWinner(Move.PAPER, Move.PAPER));
        assertEquals("It's a tie!", game.determineWinner(Move.SCISSORS, Move.SCISSORS));
    }

    @Test
    void testDetermineWinner_PlayerWins() {
        assertEquals("You win!", game.determineWinner(Move.ROCK, Move.SCISSORS));
        assertEquals("You win!", game.determineWinner(Move.PAPER, Move.ROCK));
        assertEquals("You win!", game.determineWinner(Move.SCISSORS, Move.PAPER));
    }

    @Test
    void testDetermineWinner_ComputerWins() {
        assertEquals("Computer wins!", game.determineWinner(Move.ROCK, Move.PAPER));
        assertEquals("Computer wins!", game.determineWinner(Move.PAPER, Move.SCISSORS));
        assertEquals("Computer wins!", game.determineWinner(Move.SCISSORS, Move.ROCK));
    }

    @Test
    void testFromString_ValidInputs() {
        assertEquals(Move.ROCK, Move.fromString("rock"));
        assertEquals(Move.PAPER, Move.fromString("paper"));
        assertEquals(Move.SCISSORS, Move.fromString("scissors"));

        assertEquals(Move.ROCK, Move.fromString("ROCK"));
        assertEquals(Move.PAPER, Move.fromString("PAPER"));
        assertEquals(Move.SCISSORS, Move.fromString("SCISSORS"));
    }

    @Test
    void testFromString_InvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Move.fromString("invalid");
        });
        assertTrue(exception.getMessage().contains("Invalid move"));
    }
}
