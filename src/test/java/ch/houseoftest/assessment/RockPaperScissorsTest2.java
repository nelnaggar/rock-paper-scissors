package ch.houseoftest.assessment;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsTest2 {

    @Test
    void testModeFromStringValid() {
        assertEquals(Mode.HUMAN_VS_COMPUTER, Mode.fromString("1"));
        assertEquals(Mode.HUMAN_VS_COMPUTER, Mode.fromString("human"));
        assertEquals(Mode.COMPUTER_VS_COMPUTER, Mode.fromString("2"));
        assertEquals(Mode.COMPUTER_VS_COMPUTER, Mode.fromString("computer"));
    }

    @Test
    void testModeFromStringInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Mode.fromString("xyz"));
        assertThrows(IllegalArgumentException.class, () -> Mode.fromString(""));
        assertThrows(IllegalArgumentException.class, () -> Mode.fromString("3"));
    }

    @Test
    void testHumanPlayerReturnsSetMove() {
        HumanPlayer player = new HumanPlayer();

        player.setNextMove(Move.ROCK);
        assertEquals(Move.ROCK, player.getMove());

        player.setNextMove(Move.PAPER);
        assertEquals(Move.PAPER, player.getMove());

        player.setNextMove(Move.SCISSORS);
        assertEquals(Move.SCISSORS, player.getMove());
    }

    @RepeatedTest(10)
    void testComputerPlayerProducesValidMoves() {
        ComputerPlayer player = new ComputerPlayer();
        Move move = player.getMove();
        assertNotNull(move);
        assertTrue(move == Move.ROCK || move == Move.PAPER || move == Move.SCISSORS);
    }
}
