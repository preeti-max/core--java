import java.util.Scanner;
public class ExceptionDriver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();;
        int b= sc.nextInt();
        int c= sc.nextInt();
        int result=0;
        try{
            try{
                result=a/b;
            }
            catch(NumberFormatException e){
                System.out.println("ERROR");
            }
            
            result=result/c;
            System.out.println("Result:"+ result);

        }
        catch(ArithmeticException e){
            result=0;
            System.out.println("You cannot divide the no by 0");
        }
        
        int arr[]=new int[result];
        try{
            
            System.out.println("Array at index 2 is :"+arr[2]);

        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bounds");
        }
        
    }
    
}
