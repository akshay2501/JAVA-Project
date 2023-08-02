import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = 1;
        int max = 100;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Think of a Number between " + min + " and " + max);
        System.out.println("Guess The Number!!");

        Random random = new Random();
        int SNumber = random.nextInt(max - min + 1) + min;
        int atm = 0;
        int guess;

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            atm++;

            if (guess < SNumber) {
                System.out.println("Too low!");
            } else if (guess > SNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("You Guessed the Correct Number " + SNumber + " in " + atm + " attempts!");
            }
        } while (guess != SNumber);

        scanner.close();
    }
}
