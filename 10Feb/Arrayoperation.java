import java.util.*;
class Arrayoperations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counts[]=new int[10];
        for(int i=0;i<10;i++){
            counts[i]=0;
        }
        System.out.println("Enter elements");
        for(int i=0;i<10;i++){
            counts[i]=sc.nextInt();
        }
        for(int i=0;i<10;i++){
            counts[i]+=1;
        }
        Arrays.sort(counts);
        for(int i=9;i>4;i--){
            System.out.println(counts[i]);
        }
    }
}