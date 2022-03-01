package StringOperations;
import java.util.Scanner;
class Reverse{
    private int n;
    Reverse(int n){
        this.n=n;
    }
    public int getNumber(){
        return n;
    }
    public void setNumber(int n){
        this.n=n;
    }
    
    int numberReverse(int n){
        int reversed=0;
        while(n!=0){
            int k=n%10;
            reversed=reversed*10+k;
            n=n/10;

            
        }
        return reversed;

    
    }

}

public class NumberReversal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reverse r1=new Reverse(6);
        System.out.println("Enter a number to reverse: ");
        

        int n=sc.nextInt();
        r1.setNumber(n);

        System.out.println("The original number is: "+r1.getNumber());
        System.out.println("The reversed number is :"+r1.numberReverse(n));
        
    }
    
}
