public class Additionmatrix {
    public static void main(String[] args) {
        int[][] a={{1,4},{3,5}};
        int[][] b={{1,2},{4,5}};
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j]+=b[i][j];
            }
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
}
