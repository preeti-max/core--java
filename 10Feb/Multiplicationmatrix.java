public class Multiplicationmatrix {
    static void multiply(int a[][],
                         int b[][], int c[][],int r1,int c2)
    {
        int i, j, k;

        int r2=b.length;
        for (i = 0; i < r1; i++) {
            for (j = 0; j < c2; j++) {
                c[i][j] = 0;
                for (k = 0; k < r2; k++) {
                    c[i][j] += a[i][k]
                    * b[k][j];

                }
                   
            }
        }
    }
 
    public static void main(String[] args) {
        
        int a[][] = {
            {8, 1},
           {3, 0},
           {3, 9}
       };
       int b[][] = {
           {1, 2, 1},
           {6, 2, 8}
       };
       
 
        int r1=a.length;
        int c1=a[0].length;
        int r2=b.length;
        int c2=b[0].length;
        if(r1!=c2){
            System.out.println("Multiplication not possible");
            return;

        }
        
        int res[][] = new int[r1][c2];
        int i, j;
        multiply(a, b,res,r1,c2);
        for (i = 0; i < r1; i++) {
            for (j = 0; j < c2; j++)
                System.out.print(res[i][j]
                                 + " ");
            System.out.println();
        }

    }
    
}

