package StringOperations;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tfidf {
    public static String punctuationRemoval(String content){

        return content.replaceAll("[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-]","");


    }
    
    public static String[] removeStopWord(String content){
        String stopwords[]={"i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "you’re", "you’ve", "you’ll", "you’d", "your", "yours", "yourself", "yourselves", "he", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "then", "too", "very", "s", "t", "can", "will", "just", "don", "don’t", "should", "should’ve", "now", "d", "ll", "m", "o", "re", "ve", "y", "ain", "aren’t", "could", "couldn’t", "didn’t", "didn’t"};
        String modified[]=content.split(" ");
        String[] ans;
        int count = 0;
        for (int i = 0; i < modified.length; i++) {
            for (String str : stopwords) {
                if (modified[i].equals(str)) {
                    count++;
                }
            }
        }
        ans = new String[(modified.length - count)];
        int j = 0;
        for (int i = 0; i < modified.length; i++) {
            boolean flag = true;
            for (String str : stopwords) {
                if (modified[i].equals(str)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans[j] = modified[i];
                j++;
            }
        }
        return ans;
    }
    public static String[] getUniqueWords(String[][] content) {
        HashSet<String> set = new HashSet<>();
        for (String[] file : content) {
            for (String s : file) {
                set.add(s);
            }
        }
        return set.toArray(new String[set.size()]);
    }

    public static void tf(double[][] a, String[] s, String[][] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < s.length; j++) {
                int count = 0;
                String word = s[j];
                for (int k = 0; k < content[i].length; k++) {
                    if (word.equals(content[i][k])) {
                        count++;
                    }
                }
                a[i][j] = (double) count / content[i].length;
            }
        }
    }

    public static double[] idf(String[][] content, String[] s) {
        double[] ans = new double[s.length];
        int j = 0;

        for (String word : s) {
            int count = 0;
            for (String[] file : content) {
                for (String i : file) {
                    if (i.equals(word)) {
                        count++;
                        break;
                    }
                }
            }
            ans[j] = count;
            j++;
        }
        int noOfDocuments = content.length;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Math.log10(noOfDocuments / ans[i]);
        }
        return ans;
    }

    public static void tfidf(double[][] matrix, double[] idf) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < idf.length; j++) {
                matrix[i][j] *= idf[j];
            }
        }
    }
    public static void printMatrix(double[][] matrix, String[] uniqueWords) {
        System.out.print("Document ");
        for (String word : uniqueWords)
            System.out.print(word + " ");
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("file" + (i + 1) + "   | ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%.3f", matrix[i][j]);
            }
            System.out.println();
        }
    }
    

    public static void main(String[] args) {
        String files[]={"file1.txt","file2.txt","file3.txt","file4.txt"};
        String content[][]=new String[files.length][];
        for(int i=0;i<files.length;i++){
            try (Scanner sc = new Scanner(new File(files[i]))) {
                while(sc.hasNext()) {
                    String s=sc.nextLine();
                    s=punctuationRemoval(s).toLowerCase();
                    content[i]=removeStopWord(s);

                    
                }
            }
            catch(FileNotFoundException e){
                System.out.println(e);
            }
        }
        String[] unique = getUniqueWords(content);

        double[][] matrix = new double[content.length][unique.length];

        tf(matrix,unique,content);
        double[] idf = idf(content, unique);

        tfidf(matrix, idf);
        System.out.println("TF-IDF MATRIX");
        printMatrix(matrix, unique);

        
       
        
    }
    
}
