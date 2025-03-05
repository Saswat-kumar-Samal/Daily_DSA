package Daily_DSA.Arrays.Medium_Problem;

public class Set_Matrix_Zero {
    ///  this is the Brute force approach
    /// time -->
    /// space -->
    static void markCol(int[][] mat, int n, int m, int j){
        for (int i=0; i<n; i++){
            if (mat[i][j] != 0){
                mat[i][j] = -1;
            }
        }
    }
    static void markRow(int[][] mat, int n, int m, int i){
        for (int j=0; j<m; j++){
            if (mat[i][j] != 0){
                mat[i][j] = -1;
            }
        }
    }
    static void BruteSolution(int[][] mat , int n, int m){
        //  Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (mat[i][j] == 0){
                    markRow(mat, n, m, i);
                    markCol(mat, n, m, j);
                }
            }
        }
        // // Finally, mark all -1 as 0:
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (mat[i][j] == -1){
                    mat[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat ={
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int rowNo = mat.length;
        int colNo =mat[0].length;

        BruteSolution(mat , rowNo , colNo);

        for (int[] row : mat){
            for (int ele : row){
                System.out.print(ele+ " ");
            }
            System.out.println();
        }

    }
}
