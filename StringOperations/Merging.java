package StringOperations;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;
public class Merging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.next().toLowerCase();
        String s2=sc.next().toLowerCase();
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);


        int n=c1.length;
        int m=c2.length;
        String s3="";
        int i=0;
        int j=0;
        int k=0;
        while(k<n && k<m){
            if(c1[i]<c2[j]){
                s3+=c1[i++];
                k++;
            }
            else{
                s3+=c2[j++];
                k++;
            }

        }
        while(i<n){
            s3+=s1.charAt(i++);
        }
        while(j<m){
            s3+=s2.charAt(j++);
        }
        System.out.println(s3);
    }
    
}
