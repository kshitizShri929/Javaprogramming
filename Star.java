import java.util.*;

class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueIt = true;

        while (continueIt) {
            System.out.println("Please Enter the Number want to print a diamond: ");
            int n = sc.nextInt();
            sc.nextLine(); 
            
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }

            System.out.println("Want to Continue? Enter Yes/No: ");
            String re = sc.nextLine();

            if (re.equalsIgnoreCase("no") ){
                continueIt = false;
            }
            else if (re.equalsIgnoreCase("yes")) {
                continueIt=true;
                

            }
              
            
            
        }
    }
}

    
    


