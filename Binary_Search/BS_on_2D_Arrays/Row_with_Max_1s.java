package Daily_DSA.Binary_Search.BS_on_2D_Arrays;

///  Question --> find the row of 2D matrix with maximum 1s


public class Row_with_Max_1s {
    /// this is the brute solution
    /// time --> O(n * m)
    /// space --> O(1)
    static int BruteApproach(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int idx = -1; int maxCnt = -1;
        for(int i=0; i<=n-1; i++){
            int cntRow = 0;
            for(int j=0; j<=m-1; j++){
                cntRow += mat[i][j];
            }
            if (cntRow > maxCnt){
                maxCnt = cntRow;
                idx = i;
            }
        }
        return idx;
    }



    ///  this is the Better Solution
    /// time --> O(n * log m)
    /// space --> O(1)
    public static int lowerBound(int []arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static int BetterSolution(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int idx = -1;
        int cntMax=0;
        for(int i=0; i<=n-1; i++){
            int cnt_ones = m - lowerBound(arr[i], m, 1);
            if(cnt_ones > cntMax){
                cntMax = cnt_ones;
                idx = i;
            }
        }
        return idx;
    }




    /// this is Optimal Solution
    /// time -->
    /// space -->
    static int OptimalSolution(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int rowIdx = 0;
        int colIdx = m-1;
        int max_row_idx = -1;

        while(rowIdx < n && colIdx >= 0){
            if(mat[rowIdx][colIdx] == 1){
                max_row_idx = rowIdx;
                colIdx--;
            }else{
                rowIdx++;
            }
        }
        return max_row_idx;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {0,1,1,1},
                {0,0,1,1},
                {1,1,1,1},
                {0,0,0,0}
        };
        System.out.println(OptimalSolution(mat));
    }
}
