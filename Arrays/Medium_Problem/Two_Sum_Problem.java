package Daily_DSA.Arrays.Medium_Problem;

import java.util.*;

///  you have to return the indices for the given target if the 2 elements are present in the array


public class Two_Sum_Problem {

    ///  this is the brute approach
    /// time --> nearly O(n^2)
    /// space --> O(1)
    static ArrayList<Integer> BruteApproach(int[] arr, int target){
        ArrayList<Integer> ans = new ArrayList<>();
        int n =arr.length;
        Label1:for (int i=0 ; i<=n-1;i++ ){
            for (int j=i+1; j<=n-1; j++){
                if (arr[i] + arr[j] == target) {
                    ans.add(i); ans.add(j);
                    break Label1;
                }
            }
        }
        return ans;
    }

    ///  this is better solution using the hashmap for the verity 1 , but it is the optimal solution for the Verity 2 (returning the index of 2 elements)
    /// time --> O(n) for one iteration
    /// space --> O(1)
    static ArrayList<Integer> BetterSolution(int[] arr , int target){
        int n =arr.length;
        Map<Integer, Integer> map= new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();


        for (int i=0; i<=n-1; i++){
            int rem = target - arr[i];
            if (map.containsKey(rem)){
                ans.add(map.get(rem));
                ans.add(i);
                return ans;
            }
            map.put(arr[i] , i);
        }
        return ans;
    }




    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 100;
        System.out.println("the better solution is :-> "+BetterSolution(arr,target));
    }
}
