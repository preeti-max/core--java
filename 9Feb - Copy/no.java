import java.util.Scanner;

public class no {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = 0;
        if (m > 0) {
            n = 1;
        } else if (m == 0) {
            n = 0;
        } else {
            n = -1;
        }
        System.out.println("The value of n is: "+ n);
    }

}
