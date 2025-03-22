package ch.houseoftest.assessment;

import java.util.Random;

public class RockPaperScissors {
    private final Random random = new Random();

    public Move getComputerMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }

    public String determineWinner(Move playerMove, Move computerMove) {
        if (playerMove == computerMove) {
            return "It's a tie!";
        } else if (playerMove.beats(computerMove)) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
