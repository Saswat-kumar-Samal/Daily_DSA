package Daily_DSA.Recursion;

///  this is another verity of recursion

import java.util.ArrayList;
public class CountSubsequencesOfGivenSumK {
    static int checkSubsequences(int[] arr, int target){
        ArrayList<Integer> res = new ArrayList<>();
        int ans = helperFunc(arr, 0, 0, target, res);
        return ans;
    }
    static int helperFunc(int[] arr, int idx, int sum, int target, ArrayList<Integer> res){
        if(arr.length == idx){
            if (sum == target){
                return 1;
            }else
                return 0;
        }
        res.add(arr[idx]);
        sum += arr[idx];
        int left = helperFunc(arr, idx+1, sum, target, res);
        res.removeLast();
        sum -= arr[idx];
        int right = helperFunc(arr, idx+1, sum, target, res);
        return left+right;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int sum = 2;
        System.out.println(checkSubsequences(arr, sum));
    }
}
