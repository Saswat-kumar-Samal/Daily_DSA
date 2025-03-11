package Daily_DSA.Arrays.Hard_Problems;
import java.util.*;
public class Pascals_Triangle {
    ///  optimal approach
    /// time --> O(n^2)
    /// space --> O(1)
    static List<Integer> generateRow(int row){
        int ans =1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(ans);
        for(int col=1; col<row; col++){
            ans = ans * (row - col);
            ans = ans/(col);
            ansRow.add(ans);
        }
        return ansRow;
    }
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int row = 1; row<=numRows; row++){
            list.add(generateRow(row));
        }
        return list;
    }
    public static void main(String[] args) {
        int rows = 6;
        System.out.println(generate(rows));
    }
}
