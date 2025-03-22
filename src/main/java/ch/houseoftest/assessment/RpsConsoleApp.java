package ch.houseoftest.assessment;

import java.util.Scanner;

public class RpsConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RockPaperScissors game = new RockPaperScissors();

        System.out.println("Welcome to Rock-Paper-Scissors!");
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.print("Enter your move (rock, paper, scissors): ");
            String input = scanner.nextLine();

            try {
                Move playerMove = Move.fromString(input);
                Move computerMove = game.getComputerMove();

                System.out.println("Computer chose: " + computerMove);
                String result = game.determineWinner(playerMove, computerMove);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.print("Play again? (yes/no): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("yes")) {
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
