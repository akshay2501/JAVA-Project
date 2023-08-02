import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'A' to input a string, or 'B' to input a file path: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 'A') {
            System.out.println("Enter a string: ");
            String input = scanner.nextLine();
            int wordCount = countWords(input);
            System.out.println("Number of words in the string: " + wordCount);
        } else if (choice == 'B') {
            System.out.println("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                int wordCount = countWordsFromFile(filePath);
                System.out.println("Number of words in the file: " + wordCount);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Please choose either 'A' or 'B'.");
        }

        scanner.close();
    }

    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    public static int countWordsFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
            return countWords(sb.toString());
        }
    }
}
