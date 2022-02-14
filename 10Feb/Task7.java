public class Task7 {
    public static void main(String[] args) {
        int sum=0;
        int sum1=0;
        System.out.println("loop 1");
        for(int i=1;i<=10;i++){
            sum+=i;
            System.out.println(sum);
        }
        System.out.println("loop 2");
        int k=1;
        while(true){
            sum1+=k;
            if(sum1>=100){
                break;
            }
            System.out.println(sum1);
            k++;
        }
        
        
    }


    
}





