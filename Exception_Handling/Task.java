
import java.util.Scanner;
public class Task {
    static void function(int a[]){
        if(a.length<5){
            System.out.println("No does not exist");
        }
        else{
            System.out.println("Element at index 5: "+a[4]);
        }
    }
    static float divison(int a,int b){
        return (float)a/b;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int n=sc.nextInt();
        
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();

        }
        System.out.println("Provide 2 NOs:");
        int x=sc.nextInt();
        int y=sc.nextInt();
        function(a);
        System.out.println("Division of no : "+divison(x,y));

        
    }
    
}
