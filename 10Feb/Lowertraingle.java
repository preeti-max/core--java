public class Lowertraingle {
    public static void main(String[] args) {
        int a[][]={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(i>j){
                    System.out.print(a[i][j]+" ");
                }

            }
            System.out.println();
        }
    }
    
}
