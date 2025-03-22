package ch.houseoftest.assessment;

import java.util.Random;

public class ComputerPlayer implements Player {
    private final Random random = new Random();

    @Override
    public Move getMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }
}
