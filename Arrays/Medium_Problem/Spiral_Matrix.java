package Daily_DSA.Arrays.Medium_Problem;

import java.util.*;

public class Spiral_Matrix {
    ///  this has only one solution , the Optimal solution
    /// time --> O(n * m)
    /// space --> O(n * m) to return the answer , extra space is O(1)
    static List<Integer> OptimalApproach(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int left =0; int right = m-1;
        int top = 0; int bottom = n-1;
        List<Integer> list = new ArrayList<>();
        while(top <= bottom && left <= right){
            // right
            for(int i=left ; i<=right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            // bottom
            for(int i=top; i<=bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            // left
            if(top <= bottom){  // is there really top less than bottom , this is the edge case for
                for(int i=right; i>=left; i--){   // one row matrix
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // top
            if(left <= right){  // is there really top less than bottom , this is the edge case for one
                for(int i=bottom; i>=top; i--){  // column matrix
                    list.add(matrix[i][left]);
                }
                left++;
            } 
        }
        return list;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(OptimalApproach(matrix));
    }
}
