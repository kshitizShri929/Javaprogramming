/*  directly encoded  string to string
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class CaesarCipherExample {

    private static final int SHIFT = 3; // Number of positions to shift

    private static final Set<String> USERNAME_SET = new HashSet<>();
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$"); // Valid username pattern

    public static String encrypt(String data, int shift) {
        StringBuilder result = new StringBuilder();
        for (char i : data.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isUpperCase(i) ? 'A' : 'a';
                result.append((char) ((i - base + shift) % 26 + base));
            } else {
                result.append(i);
            }
        }
        return result.toString();
    }

    public static String decrypt(String encryptedData, int shift) {
        return encrypt(encryptedData, 26 - shift); // Decrypt by shifting in the opposite direction
    }

    public static boolean isUsernameValid(String username) {
        return username != null && !username.trim().isEmpty() && USERNAME_PATTERN.matcher(username).matches();
    }

    public static boolean isUsernameUnique(String username) {
        return !USERNAME_SET.contains(username.toLowerCase());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter a username (or type 'Q/q' to exit): ");
                String username = scanner.nextLine().trim();

                if (username.equalsIgnoreCase("Q")) {
                    System.out.println("Exited");
                    break;
                }

                if (!isUsernameValid(username)) {
                    System.out.println("Invalid username. Only alphanumeric characters and underscores are allowed.");
                    continue;
                }

                String normalizedUsername = username.toLowerCase();

                if (!isUsernameUnique(normalizedUsername)) {
                    System.out.println("Username already exists. Please choose a different username.");
                    continue;
                }

                USERNAME_SET.add(normalizedUsername);

                String encryptedPassword = encrypt(username, SHIFT);
                System.out.println("Generated Encrypted Password: " + encryptedPassword);

                String decryptedUsername = decrypt(encryptedPassword, SHIFT);
                System.out.println("Decrypted Username: " + decryptedUsername);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
  //output
// Enter a username (or type 'Q/q' to exit): shri
// Generated Encrypted Password: vkul
// Decrypted Username: shri

// Enter a username (or type 'Q/q' to exit): Shri
// Username already exists. Please choose a different username.
// Enter a username (or type 'Q/q' to exit): Shri_123
// Generated Encrypted Password: Vkul_123
// Decrypted Username: Shri_123


/*string to asciivalue

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class CaesarCipherExample {

    private static final int SHIFT = 3; // Number of positions to shift

    private static final Set<String> USERNAME_SET = new HashSet<>();
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$"); // Valid username pattern

    public static String encrypt(String data, int shift) {
        StringBuilder result = new StringBuilder();
        for (char i : data.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isUpperCase(i) ? 'A' : 'a';
                result.append((char) ((i - base + shift) % 26 + base));
            } else {
                result.append(i);
            }
        }
        return result.toString();
    }

    public static String decrypt(String encryptedData, int shift) {
        return encrypt(encryptedData, 26 - shift); // Decrypt by shifting in the opposite direction
    }

    public static String convertToASCII(String data) {
        StringBuilder asciiString = new StringBuilder();
        for (char c : data.toCharArray()) {
            asciiString.append((int) c); // Convert each character to its ASCII value and append
        }
        return asciiString.toString();
    }

    public static String convertFromASCII(String asciiString) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < asciiString.length(); i += 3) { // ASCII values are generally 3 digits long
            String asciiValue = asciiString.substring(i, i + 3);
            result.append((char) Integer.parseInt(asciiValue)); // Convert each ASCII value back to character
        }
        return result.toString();
    }

    public static boolean isUsernameValid(String username) {
        return username != null && !username.trim().isEmpty() && USERNAME_PATTERN.matcher(username).matches();
    }

    public static boolean isUsernameUnique(String username) {
        return !USERNAME_SET.contains(username.toLowerCase());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter a username (or type 'Q/q' to exit): ");
                String username = scanner.nextLine().trim();

                if (username.equalsIgnoreCase("Q")) {
                    System.out.println("Exited");
                    break;
                }

                if (!isUsernameValid(username)) {
                    System.out.println("Invalid username. Only alphanumeric characters and underscores are allowed.");
                    continue;
                }

                String normalizedUsername = username.toLowerCase();

                if (!isUsernameUnique(normalizedUsername)) {
                    System.out.println("Username already exists. Please choose a different username.");
                    continue;
                }

                USERNAME_SET.add(normalizedUsername);

                String encryptedPassword = encrypt(username, SHIFT);
                String asciiPassword = convertToASCII(encryptedPassword);

                System.out.println("Generated ASCII Password: " + asciiPassword);

                String decryptedPassword = convertFromASCII(asciiPassword);
                String decryptedUsername = decrypt(decryptedPassword, SHIFT);
                System.out.println("Decrypted Username: " + decryptedUsername);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
output
Enter a username (or type 'Q/q' to exit): manishji
Generated ASCII Password: 112100113108118107109108
Decrypted Username: manishji


*/
import java.util.Scanner;
import java.util.regex.Pattern;

public class CaesarCipherExample {

    private static final int SHIFT = 3; // Number of positions to shift

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z_]+$"); // Valid username pattern

    public static String encrypt(String data, int shift) {
        StringBuilder result = new StringBuilder();
        for (char i : data.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isUpperCase(i) ? 'A' : 'a';
                result.append((char) ((i - base + shift) % 26 + base));
            // } else if (Character.isDigit(i)) {
            //     // For digits, simply shift in a circular manner
            //     result.append((char) (((i - '0' + shift) % 10) + '0'));
             } 
            // else 
            // {
            //     result.append(i); // Append non-alphabetic characters as they are
            // }
        }
        return result.toString();
    }

    public static String decrypt(String encryptedData, int shift) {
        return encrypt(encryptedData, 26 - shift); // Decrypt by shifting in the opposite direction
    }

    public static boolean isUsernameValid(String username) {
        return username != null && !username.trim().isEmpty() && USERNAME_PATTERN.matcher(username).matches();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter a username (or type 'Q/q' to exit): ");
                String username = scanner.nextLine().trim();

                if (username.equalsIgnoreCase("Q")) {
                    System.out.println("Exited");
                    break;
                }

                if (!isUsernameValid(username)) {
                    System.out.println("Invalid username. Only alphanumeric characters and underscores are allowed.");
                    continue;
                }

                String encryptedPassword = encrypt(username, SHIFT);
                System.out.println("Generated Encrypted Password: " + encryptedPassword);

                String decryptedUsername = decrypt(encryptedPassword, SHIFT);
                System.out.println("Decrypted Username: " + decryptedUsername);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

