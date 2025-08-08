package Daily_DSA.Recursion;

/// this is the combination sum part - 1;
///  this question is solved by using pick and non-pick concept


import java.util.*;
public class CombinationSum1 {
    private static List<List<Integer>> ANS = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helperFunc(candidates, 0, target, new ArrayList<>());
        return ANS;
    }
    static void helperFunc(int[] candidates, int idx, int target, List<Integer> sublist){
        if(idx == candidates.length){
            if(target == 0){
                ANS.add(new ArrayList<>(sublist));
            }
            return;
        }
        if(idx < candidates.length && candidates[idx] <= target){
            sublist.add(candidates[idx]);
            helperFunc(candidates, idx, target - candidates[idx], sublist);
            sublist.removeLast();
        }
        helperFunc(candidates, idx+1, target, sublist);
        return;
    }
    public static void main(String[] args) {

    }
}
