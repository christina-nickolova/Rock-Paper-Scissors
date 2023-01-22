import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerMove = scanner.nextLine();

        switch (playerMove) {
            case "r", "rock" -> playerMove = ROCK;
            case "p", "paper" -> playerMove = PAPER;
            case "s", "scissors" -> playerMove = SCISSORS;
            default -> {
                System.out.println("Invalid Input. Try Again...");
                return;
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
            System.out.println("You win.");
        } else if ((playerMove.equals("Rock") && computerMove.equals("Rock")) ||
                (playerMove.equals("Paper") && computerMove.equals("Paper")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Scissors"))) {
            System.out.println("This game was a draw.");
        } else {
            System.out.println("You lose.");
        }
    }
}
