import java.util.*;

public class Case {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int l = 0, u = 0, d = 0, sp = 0;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                u += 1;
            }
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                l += 1;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                d += 1;
            } else   {  
                sp=sp+1;
            }

        }
        System.out.println("Count of lowercase character: " + l);
        System.out.println("Count of uppercase character: " + u);
        System.out.println("Count of digits: " + d);
    }

}
