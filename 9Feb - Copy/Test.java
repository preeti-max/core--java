import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no for the operation you want to perform");
        System.out.println("1.ADD  2.SUB  3.MUL  4.DIV  5.MODULUS");
        int i = sc.nextInt();

        System.out.println("Enter  2 numbers num1 and num2:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        switch (i) {
            case 1:
                System.out.println("Sum is: " + (a + b));
                break;
            case 2:
                System.out.println("Diff is: " + (a - b));
                break;
            case 3:
                System.out.println("Product is: " + (a * b));
                break;
            case 4:
                if (b == 0) {
                    System.out.println("Error: Don't divide a number by zero ");
                } else {
                    System.out.println("Quotient is: " + ((double) a / b));
                }
                break;
            case 5:
                if (b == 0) {
                    System.out.println("Error: Don't divide a number by zero ");
                } else {
                    System.out.println("Remainder is: " + (a % b));
                }
                break;
            default:
                System.out.println("You have entered a wrong number.Program Exiting");

        }

    }

}
