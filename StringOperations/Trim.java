package StringOperations;
import java.util.Scanner;

public class Trim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s="   item   ";
        
        int n=s.length();
        int i=0,j=n-1;
        while(i<n && s.charAt(i)==' '){
            
            i++;


        }
        while(j>=0 && s.charAt(j)==' '){
            j--;

        
    }
    System.out.println(s.substring(i,j+1));
    System.out.println(n);
    System.out.println(s.substring(i,j+1).length());
    
}
}