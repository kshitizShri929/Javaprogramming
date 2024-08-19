import java.util.Scanner;

public class CaesarCipherAlgo {
    private static final int SHIFT = 3; 

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

            String encryptedPassword = encrypt(input);
            String decryptedUsername = decrypt(encryptedPassword);

            System.out.println("Generated Encrypted Password: " + encryptedPassword);
            System.out.println("Decrypted Username: " + decryptedUsername);
        }

        scanner.close();
    }

    private static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char i : input.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isLowerCase(i) ? 'a' : 'A';
                encrypted.append((char) ((i - base + SHIFT) % 26 + base));
            } else if (Character.isDigit(i)) {
                encrypted.append((char) ((i - '0' + SHIFT) % 10 + '0'));
            } else {
                encrypted.append(i); 
            }
        }
        return encrypted.toString();
    }

    private static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char i : input.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isLowerCase(i) ? 'a' : 'A';
                decrypted.append((char) ((i - base - SHIFT + 26) % 26 + base));
            } else if (Character.isDigit(i)) {
                decrypted.append((char) ((i - '0' - SHIFT + 10) % 10 + '0'));
            } else {
                decrypted.append(i); 
            }
        }
        return decrypted.toString();
    }
}

