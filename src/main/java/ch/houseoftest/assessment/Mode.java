package ch.houseoftest.assessment;

public enum Mode {
    HUMAN_VS_COMPUTER,
    COMPUTER_VS_COMPUTER;

    public static Mode fromString(String input) {
        switch (input.toLowerCase()) {
            case "1":
            case "human":
                return HUMAN_VS_COMPUTER;
            case "2":
            case "computer":
                return COMPUTER_VS_COMPUTER;
            default:
                throw new IllegalArgumentException("Invalid mode: " + input);
        }
    }
}
