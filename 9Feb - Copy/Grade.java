import java.util.*;

public class Grade {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int total = a + b + c;
        int p = total / 3;
        System.out.println("total marks is: " + total);
        if (p >= 90) {
            System.out.println("GRADE A");
        } else if (p >= 80) {
            System.out.println("GRADE B");
        } else if (p >= 70) {
            System.out.println("GRADE C");
        } else if (p >= 60) {
            System.out.println("GRADE D");
        } else {
            System.out.println("GRADE F");
        }

    }
}