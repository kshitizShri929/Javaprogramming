// import java.util.Scanner;

// public class PasswordGenerator {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Take username input
//         System.out.print("Enter username: ");
//         String username = scanner.nextLine();

//         // Generate password
//         String password = generatePassword(username);

//         // Display the password
//         System.out.println("Generated password: " + password);
//     }

//     private static String generatePassword(String username) {
//         StringBuilder passwordBuilder = new StringBuilder();
//         int sum = 0;

//         // Iterate over each character in the username
//         for (char ch : username.toCharArray()) {
//             // Calculate the alphabetical position (A=1, B=2, ..., Z=26)
//             int position = Character.toUpperCase(ch) - 'A' + 1;
//             passwordBuilder.append(position);
//             sum += position; // Add position to sum
//         }

//         // Add the sum of the positions at the end of the password
//         passwordBuilder.append(sum);

//         return passwordBuilder.toString();
//     }
// }

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {
    private static Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter your username (or type 'exit' to quit): ");
            String username = scanner.nextLine();
            if (username.equalsIgnoreCase("exit")) {
                break;
            }

            if (userDatabase.containsKey(username)) {
                System.out.println("Username already exists. Please try a different username.");
            } else {
                String generatedPassword = generatePassword(username);
                userDatabase.put(username, generatedPassword);
                System.out.println("Your generated password: " + generatedPassword);
            }

            System.out.print("Enter password to verify your username: ");
            String inputPassword = scanner.nextLine();
            String verifiedUsername = verifyPassword(inputPassword);

            if (verifiedUsername != null) {
                System.out.println("The username corresponding to the entered password is: " + verifiedUsername);
            } else {
                System.out.println("Incorrect password. No matching username found.");
            }
        }

        scanner.close();
    }

    private static String generatePassword(String username) {
        StringBuilder passwordBuilder = new StringBuilder();
        
        for (char ch : username.toCharArray()) {
            int position = Character.toUpperCase(ch) - 'A' + 1;
            passwordBuilder.append(position);
        }

        return passwordBuilder.toString();
    }

    private static String verifyPassword(String inputPassword) {
        for (Map.Entry<String, String> entry : userDatabase.entrySet()) {
            if (inputPassword.equals(entry.getValue())) {
                return entry.getKey(); 
            }
        }
        return null; 
    }
}
