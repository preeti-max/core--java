public class Largestsmallest {
    public static void main(String[] args) {
        int a[]={2,1,8,98,0,65,1,45};
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++) {
            min=Math.min(a[i],min);
            max=Math.max(a[i],max);
        }
        System.out.println("MAX VALUE IS: "+max);
        System.out.println("Min VALUE IS: "+min);
    }
    
}
