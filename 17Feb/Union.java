import java.util.*;

public class Union {
    static int union(int arr1[],int arr2[]){
        int i=0,j=0,count = 0;
        int n=arr1.length;
        int m=arr2.length;
        while(i<n && j<m){
            if(arr1[i] == arr2[j]) 
                count++;
            else 
                count += 2;
            i++;
            j++;
        }
        if(i<n) 
            return count+(n-i);
        return count +(m-j);
        
        

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[m];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        
        System.out.println("count is: "+union(a,b));
       


        
    }
    
}
