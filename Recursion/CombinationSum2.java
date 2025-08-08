package Daily_DSA.Recursion;

///  this is combination sum part - 2
/// this question is solved by using 'pick subsequences'
/// we will modify the recursion in different way

///  very very important pattern of backtracking

import java.util.*;
public class CombinationSum2 {
    static List<List<Integer>> ANS = new ArrayList<>();
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helperFunc(candidates, 0, target, new ArrayList<>());
        return ANS;
    }
    static void helperFunc(int[] candidates, int idx, int target, List<Integer> sublist){
        if(target == 0){
            ANS.add(new ArrayList<>(sublist));
            return;
        }
        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            sublist.add(candidates[i]);
            helperFunc(candidates, i+1, target - candidates[i], sublist);
            sublist.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum2(arr, target));
    }
}
