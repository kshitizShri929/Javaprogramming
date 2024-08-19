import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CaesarCipherE {
    private static final int SHIFT = 3; // Caesar cipher shift
    private static Set<String> userNames = new HashSet<>(); // To store unique usernames

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Enter a username (or type 'Q/q' to exit): ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Q")) {
                System.out.println("Exited");
                break;
            }

            if (userNames.contains(input)) {
                System.out.println("Username already exists. Please choose a different username.");
                continue;
            }

            // Encrypt the username
            String encryptedPassword = encrypt(input);
            // Decrypt the username for display purposes
            String decryptedUsername = decrypt(encryptedPassword);

            // Store the username
            userNames.add(input);

            System.out.println("Generated Encrypted Password: " + encryptedPassword);
            System.out.println("Decrypted Username: " + decryptedUsername);
        }

        scanner.close();
    }

    // Encrypt using Caesar cipher
    private static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char i : input.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isLowerCase(i) ? 'a' : 'A';
                encrypted.append((char) ((i - base + SHIFT) % 26 + base));
            } else {
                encrypted.append(i); // For numbers and other characters
            }
        }
        return encrypted.toString();
    }

    // Decrypt using Caesar cipher
    private static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char i : input.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isLowerCase(i) ? 'a' : 'A';
                decrypted.append((char) ((i - base - SHIFT + 26) % 26 + base));
            } else {
                decrypted.append(i); // For numbers and other characters
            }
        }
        return decrypted.toString();
    }
}
