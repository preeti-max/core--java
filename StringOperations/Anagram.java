package StringOperations;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static boolean isAnagram(String s1,String s2){
        
        s1=s1.replace(" ","");
        s2=s2.replace(" ","");
        if(s1.length()!=s2.length()){
            return false;
        }
        char c1[]=s1.toUpperCase().toCharArray();
        char c2[]=s2.toUpperCase().toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);

    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    String str1 = sc.nextLine();
    String str2 = sc.nextLine();
    System.out.println(isAnagram(str1,str2)?"They are anagram":"They are not anagram");
}
}
