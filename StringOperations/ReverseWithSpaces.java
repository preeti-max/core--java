package StringOperations;

import java.util.Scanner;

public class ReverseWithSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char a[] = s.toCharArray();

        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (a[i] == ' ') {
                i++;
            } else if (a[j] == ' ') {
                j--;
            } else {
                char k = a[i];
                a[i] = a[j];
                a[j] = k;
                i++;
                j--;
            }

        }

        System.out.println(a);

    }

}
