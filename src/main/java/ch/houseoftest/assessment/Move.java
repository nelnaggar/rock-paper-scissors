package ch.houseoftest.assessment;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public boolean beats(Move other) {
        return (this == ROCK && other == SCISSORS)
            || (this == SCISSORS && other == PAPER)
            || (this == PAPER && other == ROCK);
    }

    public static Move fromString(String input) {
        switch (input.toLowerCase()) {
            case "rock": return ROCK;
            case "paper": return PAPER;
            case "scissors": return SCISSORS;
            default: throw new IllegalArgumentException("Invalid move: " + input);
        }
    }
}
