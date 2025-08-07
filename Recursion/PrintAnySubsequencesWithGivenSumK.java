package Daily_DSA.Recursion;


/// this is the another technique of recursion


import java.util.*;
public class PrintAnySubsequencesWithGivenSumK {
    static void checkSubsequences(int[] arr, int target){
        ArrayList<Integer> res = new ArrayList<>();
        helperFunc(arr, 0, 0, target, res);
    }
    static boolean helperFunc(int[] arr, int idx, int sum, int target, ArrayList<Integer> res){
        if(arr.length == idx){
            if (sum == target){
                System.out.println(res);
                return true;
            }else
                return false;
        }
        res.add(arr[idx]);
        sum += arr[idx];
        if(helperFunc(arr, idx+1, sum, target, res)) return true;
        res.removeLast();
        sum -= arr[idx];
        if(helperFunc(arr, idx+1, sum, target, res)) return true;
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {7,2,4,3};
        int sum = 3;
        checkSubsequences(arr, sum);
    }
}
