package ch.houseoftest.assessment;

public class HumanPlayer implements Player {
    private Move nextMove;

    public void setNextMove(Move move) {
        this.nextMove = move;
    }

    @Override
    public Move getMove() {
        return nextMove;
    }
}
