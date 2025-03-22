package ch.houseoftest.assessment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RpsSwingApp {
    private JFrame frame;
    private JComboBox<String> modeSelector;
    private JButton rockButton, paperButton, scissorsButton, clearButton;
    private JTextArea resultArea;

    private final RockPaperScissors game = new RockPaperScissors();
    private final ComputerPlayer computer = new ComputerPlayer();
    private final HumanPlayer human = new HumanPlayer();

    private Mode currentMode;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RpsSwingApp().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Rock Paper Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(new BorderLayout());

        // Top: Mode selection
        JPanel modePanel = new JPanel();
        modeSelector = new JComboBox<>(new String[]{"Human vs Computer", "Computer vs Computer"});
        JButton startButton = new JButton("Start Game");
        modePanel.add(new JLabel("Select Mode:"));
        modePanel.add(modeSelector);
        modePanel.add(startButton);

        // Center: Game result
        resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Bottom: Move buttons
        JPanel movePanel = new JPanel();
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        clearButton = new JButton("Clear");

        movePanel.add(rockButton);
        movePanel.add(paperButton);
        movePanel.add(scissorsButton);
        movePanel.add(clearButton);

        frame.add(modePanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(movePanel, BorderLayout.SOUTH);

        // Add listeners (without lambdas)
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound(Move.ROCK);
            }
        });

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound(Move.PAPER);
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound(Move.SCISSORS);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
            }
        });

        toggleMoveButtons(false);
        clearButton.setEnabled(false);

        frame.setVisible(true);
    }

    private void startGame() {
    	String selected = (String) modeSelector.getSelectedItem();
        if (selected.contains("Human")) {
            currentMode = Mode.HUMAN_VS_COMPUTER;
            toggleMoveButtons(true);
            appendResult("Game started: Human vs Computer\nChoose your move.");
        } else {
            currentMode = Mode.COMPUTER_VS_COMPUTER;
            toggleMoveButtons(false);
            runComputerVsComputer();
        }
    }

    private void playRound(Move move) {
        if (currentMode == Mode.HUMAN_VS_COMPUTER) {
            human.setNextMove(move);
            Move playerMove = human.getMove();
            Move computerMove = computer.getMove();
            String result = game.determineWinner(playerMove, computerMove);
            appendResult("You chose: " + playerMove + "\nComputer chose: " + computerMove + "\n" + result + "\n");
            clearButton.setEnabled(true);
        }
    }

    private void runComputerVsComputer() {
        Move move1 = computer.getMove();
        Move move2 = computer.getMove();
        String result = game.determineWinner(move1, move2);
        appendResult("Computer 1 chose: " + move1 + "\nComputer 2 chose: " + move2 + "\n" + result + "\n");
        clearButton.setEnabled(true);
    }

    private void toggleMoveButtons(boolean enabled) {
        rockButton.setEnabled(enabled);
        paperButton.setEnabled(enabled);
        scissorsButton.setEnabled(enabled);
    }

    private void appendResult(String text) {
        resultArea.append(text + "\n");
    }
}
