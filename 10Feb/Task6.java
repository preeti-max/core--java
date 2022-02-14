import java.util.*;

public class Task6 {
    static boolean isprime(int n){
        if(n<=1)
            return false;
        if(n==2)
            return true;
        if(n%2==0)
            return false;

    
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
    static boolean isArmstong(int n){
        int count=0;
        int temp=0;
        int last=0;
        int sum=0;
        temp=n;
        while(temp!=0){
            temp=temp/10;
            count++;
        }
        temp=n;
        while(temp!=0){
            last=temp%10;
            sum+=Math.pow(last,count);
            temp=temp/10;

        }
        return sum==n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for(int i=1;i<=n;i++){
            if(isprime(i)){
                System.out.println("Prime: "+i);
            }
            else{
                if(isArmstong(n)){
                    System.out.println("Armstong: "+i);
                }
                else{
                    System.out.println( "Not Armstong: "+i);
                }
            }
        }
        
    }
    
}














