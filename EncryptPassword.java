import java.util.Scanner;

public class EncryptPassword {

    
    public static String encryptPassword(String username, int shift) {
        StringBuilder password = new StringBuilder();
        for (char character : username.toCharArray()) {
            
            if (Character.isLetter(character)) {
                
                char ch = Character.isLowerCase(character) ? 'a' : 'A';
                
                char encryptedChar = (char) ((character + shift - ch) % 26 + ch);
                password.append(encryptedChar);
            } else {
            
                password.append(character);
            }
        }
        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.print("Enter username (or Enter 'Q/q' to exit): ");
            String username = scanner.nextLine(); 

            
            if (username.equalsIgnoreCase("Q")) {
                System.out.println("Exiting the program!");
                break; 
            }

            
            int shift = 3; 

            
            String encryptedPassword = encryptPassword(username, shift);
            System.out.println("Encrypted password: " + encryptedPassword);
        }

        scanner.close();
    }
}


//output:Enter username (or Enter 'Q/q' to exit): shrikant
//Encrypted password: vkulndqw