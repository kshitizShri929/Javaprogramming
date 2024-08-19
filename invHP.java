import java.util.Scanner;

public class invHP {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
        System.out.println("Enter number N :");
        int n=sc.nextInt();
       
        //int m= sc.nextInt();

        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){ 
              System.out.print("*");
            }
            System.out.println();
        }

    }
    
}
