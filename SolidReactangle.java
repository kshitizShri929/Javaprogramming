import java.util.Scanner;

public class SolidReactangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number N and M :");
        int n=sc.nextInt();
       
        int m= sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){ 
              System.out.print(" * ");
            }
            System.out.println();
        }

    }
}
