public class Sortmatrix {
    public static void main(String[] args) {
        int a[]={1,3,6,8,9};
        int b[]={0,2,5,6,7};
        int n=a.length+b.length;
        int c[]=new int[n];
        int k=0;
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                c[k++]=a[i++];
            
                
            }
            else{
                c[k++]=b[j++];
            
            }


        }
        while(i<a.length){
            c[k++]=a[i++];
        }
        while(j<b.length){
            c[k++]=b[j++];
        }
        for(int l:c){
            System.out.println(l);
        }
    }
    
}
