package Daily_DSA.Arrays.Hard_Problems;


import java.util.*;

///  Question - > Given an array of intervals, merge all the overlapping intervals and
///                return an array of non-overlapping intervals.


public class Merge_Overlapping_SubIntervals {
    ///  this is the brute Approach
    /// time --> O(n * log n) + O(2n) every time we are traversing twice
    /// space --> O(n)
    static List<List<Integer>> BruteApproach(int[][] intervals){
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for(int i=0; i<=n-1; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!ans.isEmpty() && end <= ans.getLast().get(1)) continue;
            for(int j=i+1; j<=n-1; j++){
                if (intervals[j][0] <= end) end = Math.max(end , intervals[j][1]);
                else break;
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }


    /// this is the Optimal Approach
    /// time --> O(n * log n) + O(n)
    /// space --> O(n) I am using that space for doing that algo and as well as I am returning the ans also
    static List<List<Integer>> OptimalApproach(int[][] intervals){
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for(int i=0; i<=n-1; i++){
            if (ans.isEmpty() || intervals[i][0] > ans.getLast().get(1)){
                ans.add(Arrays.asList(intervals[i][0] , intervals[i][1]));
            }else{
                ans.getLast().set(1, Math.max(ans.getLast().get(1) , intervals[i][1]));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {9,11},
                {8,9},
                {8,10},
                {2,4},
                {15,18},
                {16,17}
        };
        System.out.println(OptimalApproach(intervals));
    }
}
