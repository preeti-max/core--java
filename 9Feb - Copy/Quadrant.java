import java.util.Scanner;
public class Quadrant {
    public static void main(String args[]) {
        System.out.println("enter x and y coordinates");
         Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        if (x > 0 && y > 0)
            System.out.println("First quadrant");
 
        else if (x < 0 && y > 0)
            System.out.println("Second quadrant");
 
        else if (x < 0 && y < 0)
            System.out.println("Third quadrant");
 
        else if (x > 0 && y < 0)
            System.out.println("Fourth quadrant");
        else if(x==0 && y==0){
            System.out.println("Origin");
        }
 

      
    }
}