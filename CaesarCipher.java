import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CaesarCipher {
    private static final int SHIFT = 3; 
    private static Set<String> userNames = new HashSet<>();

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

            // if (userNames.contains(input)) {
            //     System.out.println("Username already exists. Please choose a different username.");
            //     continue;
            // }

            
            String encryptedPassword = encrypt(input);
            
            String decryptedUsername = decrypt(encryptedPassword);

            
            userNames.add(input);

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
/*
 Case 1: Normal Username
 Case 2: Numeric Username
 case3:mix characters
 case4:duplicate Username
 Case 5: Special Characters
 *Not case sensitive Username


Enter a username (or type 'Q/q' to exit): shri
Generated Encrypted Password: vkul
Decrypted Username: shri
Enter a username (or type 'Q/q' to exit): 23456
Generated Encrypted Password: 56789
Decrypted Username: 23456
Enter a username (or type 'Q/q' to exit): shri@2025
Generated Encrypted Password: vkul@5358
Decrypted Username: shri@2025
Enter a username (or type 'Q/q' to exit): 245Raj
Generated Encrypted Password: 578Udm
Decrypted Username: 245Raj
Enter a username (or type 'Q/q' to exit): 245Raj      
Username already exists. Please choose a different username.
Enter a username (or type 'Q/q' to exit): ^Csk@sk:~/JavaProgramming$ 


 */