import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------");
        System.out.println("~ROCK PAPER SCISSORS GAME~");
        System.out.println("--------------------------");
        System.out.println();

        System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerMove = scanner.nextLine();

        int playerScore = 0;
        int computerScore = 0;
        int playedGames = 0;

        while (!playerMove.matches("^(?i:end game)$")) {

            switch (playerMove) {
                case "r", "rock" -> {
                    playerMove = ROCK;
                    playedGames++;
                }
                case "p", "paper" -> {
                    playerMove = PAPER;
                    playedGames++;
                }
                case "s", "scissors" -> {
                    playerMove = SCISSORS;
                    playedGames++;
                }
                default -> {
                    System.out.println("Invalid Input. Try Again...");
                    playerMove = scanner.nextLine();
                    continue;
                }
            }
            Random random = new Random();
            int computerRandomNumber = random.nextInt(4);

            String computerMove;

            if (computerRandomNumber == 1) {
                computerMove = ROCK;
            } else if (computerRandomNumber == 2) {
                computerMove = PAPER;
            } else {
                computerMove = SCISSORS;
            }
            System.out.printf("The computer chose %s.%n", computerMove);

            if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                    (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                    (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
                playerScore++;
                System.out.println("You win :)");
            } else if ((playerMove.equals("Rock") && computerMove.equals("Rock")) ||
                    (playerMove.equals("Paper") && computerMove.equals("Paper")) ||
                    (playerMove.equals("Scissors") && computerMove.equals("Scissors"))) {
                playerScore++;
                computerScore++;
                System.out.println("This game was a draw.");
            } else {
                computerScore++;
                System.out.println("You lose :(");
            }
            playerMove = scanner.nextLine();
        }
        System.out.println("---RESULTS---");
        System.out.printf("Your score: %d%nComputer score: %d%n", playerScore, computerScore);
        System.out.println("-------------");
        System.out.println("Played games: " + playedGames);
    }
}
