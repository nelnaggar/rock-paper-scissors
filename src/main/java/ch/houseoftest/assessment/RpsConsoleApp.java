package ch.houseoftest.assessment;

import java.util.Scanner;

public class RpsConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RockPaperScissors game = new RockPaperScissors();

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Choose game mode:");
        System.out.println("1 - Human vs Computer");
        System.out.println("2 - Computer vs Computer");

        Mode mode;
        
        
        while (true) {
            System.out.print("Enter 1 or 2: ");
            String modeInput = scanner.nextLine();
            try {
                mode = Mode.fromString(modeInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        HumanPlayer humanPlayer = new HumanPlayer();
        Player player1 = (mode == Mode.HUMAN_VS_COMPUTER ) ? humanPlayer : new ComputerPlayer();
        Player player2 = new ComputerPlayer();

        boolean keepPlaying = true;

        while (keepPlaying) {
            Move move1;

            if (mode == Mode.HUMAN_VS_COMPUTER) {
                move1 = promptForMove(scanner);
                humanPlayer.setNextMove(move1);
            }

            move1 = player1.getMove();
            Move move2 = player2.getMove();

            System.out.println("Player 1 chose: " + move1);
            System.out.println("Player 2 chose: " + move2);

            String result = game.determineWinner(move1, move2);
            System.out.println(result);

            System.out.print("Play again? (yes/no): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("yes")) {
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static Move promptForMove(Scanner scanner) {
        while (true) {
            System.out.print("Enter your move (rock, paper, scissors): ");
            String input = scanner.nextLine();
            try {
                return Move.fromString(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
