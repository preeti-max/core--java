import java.util.Scanner;
interface in1
{
    void display(int p);
}
class testClass implements in1{

    public boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                prime = false;
        }
        return prime;
    }
    public void display(int k) {
        int count = 0;
        for (int i = 2; i <= k; i++) {
            if (isPrime(i))
                count++;
        }
        System.out.println(count);

    }

}

public class Inteface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n= sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            testClass test = new testClass();
            test.display(arr[i]);
        }
        
        

        
    }
    
}
