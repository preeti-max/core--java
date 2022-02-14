import java.util.*;
public class Digitextract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a > 0) {
            int remainder = a % 10;
            System.out.println(remainder);

            a = a / 10;
        }
    }
    
}
