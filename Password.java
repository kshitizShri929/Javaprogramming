import java.util.Scanner;
public class Password {
    private static String storedUsername;
    private static String storedPassword;
    


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your username: ");
        storedUsername = scanner.nextLine();
        storedPassword = generatePassword(storedUsername);
        System.out.println(" Your generated password: " + storedPassword);
        System.out.print("Enter password to verify  your username: ");
        String inputPassword = scanner.nextLine();

    
        String username = verifyPassword(inputPassword);
        if (username != null) {
            System.out.println("The username corresponding to the entered password is: " + username);
        } else {
            System.out.println("Incorrect password. No matching username found.");
        }

        scanner.close();
    }

    private static String generatePassword(String username) {
        StringBuilder passwordBuilder = new StringBuilder();
        //int sum = 0;

    
        for (char ch : username.toCharArray()) {
            int position = Character.toUpperCase(ch) - 'A' + 1;
            passwordBuilder.append(position);
            //sum += position; 
        }

        
        //passwordBuilder.append(sum);

        return passwordBuilder.toString();
    }

    private static String verifyPassword(String inputPassword) {
        
        if (inputPassword.equals(storedPassword)) {
            return storedUsername; 
        }
        return null; 
    }
}





