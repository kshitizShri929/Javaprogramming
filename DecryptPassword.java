import java.util.Scanner;

public class DecryptPassword {

    public static String decryptPassword(String password, int shift) {
        StringBuilder dp = new StringBuilder();

        for (char character : password.toCharArray()) {
            
            if (Character.isLetter(character)) {
            
                char ch = Character.isUpperCase(character) ? 'A' : 'a';
                
                char decryptedChar = (char) ((character - shift - ch + 26) % 26 + ch);
                dp.append(decryptedChar);
            } else {
                
                dp.append(character);
            }
        }
        return dp.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;

        while (true) {
            System.out.print("Enter password (or Enter Q/q' to exit): ");
            password = scanner.nextLine(); 

            
            if (password.equalsIgnoreCase("q")) {
                System.out.println("Exiting the program!");
                break; 
            }

            int shift = 3;
            String username = decryptPassword(password, shift);
            System.out.println("Decrypted username: " + username);
        }

        scanner.close();
    }
}
//output
// Enter password (or Enter Q/q' to exit): vkulndqw
// Decrypted username: shrikant
// Enter password (or Enter Q/q' to exit):

