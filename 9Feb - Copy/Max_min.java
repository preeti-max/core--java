import java.util.Scanner;
public class Max_min {
    public static void main(String args[]) {
         Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int small=Math.min(a,Math.min(b,c));
        int large=Math.max(a,Math.max(b,c));
        System.out.println("Smallest is: "+small);
        System.out.println("Largestt is: "+large);

      
    }
}