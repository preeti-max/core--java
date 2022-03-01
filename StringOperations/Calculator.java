package StringOperations;

import java.util.*;
class Operations{
    static int add(int a, int b){
        return a+b;
    }
    static int sub(int a, int b){
        return a-b;
    }
    static int mul(int a, int b){
        return a*b;
    }
    static void div(int a, int b){
        double div=0;
        try{
            if(b==0)
                throw new ArithmeticException();
            div=(double)a/b;
            
            System.out.printf("The quotient on dividing %d by %d is : %f",a,b,div);
        }
        catch(ArithmeticException e){
            System.out.println("You cannot divide the number by 0.");

        }
        
    }
    static void remainder(int a,int b){
        int rem=0;
        try{
            rem=a%b;
            System.out.printf("The remainder on dividing %d by %d is : %d",a,b,rem);
            
        }
        catch(ArithmeticException e){
            System.out.println("You cannot divide the number by 0.");

        }
    
        
        
    }

}

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice, num1, num2;
    char ch;
    do {
        System.out.println("Enter the number corresponding to the operation you wish to perform");
        System.out.println("1. Addition \n2. Subtraction \n3. Multiplication \n4. Divison \n5. Modulus");
        choice = sc.nextInt();
        System.out.println("Enter num1 ");
        num1 = sc.nextInt();
        System.out.println("Enter num2 ");
        num2 = sc.nextInt();
       

        switch (choice) {
            case 1:
                System.out.println("Sum is " + Operations.add(num1, num2));
                break;
            case 2:
                System.out.println("Difference is " +Operations.sub(num1, num2));
                break;
            case 3:
                System.out.println("Multiplication is " + Operations.mul(num1, num2));
                break;
            case 4:
                Operations.div(num1,num2);
                break;
            case 5:
               Operations.remainder(num1,num2);
                break;
            default:
                System.out.println("You have choosed the wrong option.");

        }
        System.out.println("\nPress Y to continue");
        ch = sc.next().charAt(0);
    } while (ch == 'Y' || ch == 'y');

    
}

}


