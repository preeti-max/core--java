import java.util.Scanner;

public class Userinput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        String s = sc.nextLine();

        while (!s.equals("q")) {
            count++;
            s = sc.nextLine();
        }
        System.out.println("Count is: " + count);
    }
}
    
