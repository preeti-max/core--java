import java.util.*;
class HappyNumber {
    static int squareSum(int n){
        int sum=0;
        while(n!=0){
            int k=n%10;
            sum+=k*k;
            n=n/10;
        }
        return sum;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer>a=new ArrayList<Integer>();
        int k=n;
        while(n!=1 && n!=4 ){
            n=squareSum(n);
            a.add(n);

        }
        if(n==1){
            System.out.println("The first "+k+" happy numbers from the number are:");
            System.out.println(a);
        }
        else{
            System.out.println("Not a happy number");
        }
        
        



        
    }
    
}
