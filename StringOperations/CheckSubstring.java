package StringOperations;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckSubstring {
    static boolean isSubstring(String s1,String s2){
        int M=s1.length();
        int N=s2.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (s2.charAt(i + j)
                    != s1.charAt(j))
                    break;
 
            if (j == M)
                return true;
        }
 
        return false;


    }
    static boolean allSubstring(ArrayList<String>a,String s){
        
            for(String i:a){
                if(!isSubstring(i,s)){
                    return false;
                }
            }
            return true;
           
        }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String mainStr=sc.next().toLowerCase();
        ArrayList<String> possibleSubstrings=new ArrayList<>();
        int i=0;
        while(sc.hasNext()){
            String s= sc.next().toLowerCase();
            if(s.matches("[0-9]+")){
                break;
            }
            possibleSubstrings.add(s);

        }
        System.out.println(allSubstring(possibleSubstrings,mainStr)?"True":"False");
        
    }
    
}
