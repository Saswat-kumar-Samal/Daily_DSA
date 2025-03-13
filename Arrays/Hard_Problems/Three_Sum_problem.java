package Daily_DSA.Arrays.Hard_Problems;

///  Google Question --> you have given an array u have to return the unique
///               triplet which is giving me the sum 0

import java.util.*;
public class Three_Sum_problem {
    ///  this is brute approach
    /// time --> O(n^3)
    /// space --> O(no of unique triplet)
    static List<List<Integer>> BruteApproach(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<=n-1; i++){
            for(int j=i+1; j<=n-1; j++){
                for(int k=j+1; k<=n-1; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j] , arr[k]);
                        temp.sort(null);
                        set.add(temp);
                    }
                }
            }
        }
        ans.addAll(set);
        return ans;
    }



    ///  this is better approach by using Hashing
    /// time -->
    /// space -->
    static List<List<Integer>> BetterApproach(int[] arr){
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0; i<=n-1; i++){
            Set<Integer> set = new HashSet<>();
            for (int j=i+1; j<=n-1; j++){
                int third = -(arr[i]+arr[j]);
                if (set.contains(third)){
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                set.add(arr[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(st);
        return ans;
    }


    ///  this is the Optimal Approach by using the 2 pointer technique
    /// time --> O(n * log n) + O(n^2)
    /// space --> O(1)
    static List<List<Integer>> OptimalApproach(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<=n-1; i++){
            // Skip duplicate elements for i
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    // Found a triplet with sum Zero
                    List<Integer> temp = Arrays.asList(nums[i] , nums[j] , nums[k]);
                    ans.add(temp);
                    // Move the pointers
                    j++;
                    k--;
                    // Skip duplicate elements for j
                    while(j < k && nums[j] == nums[j-1]) j++;
                    // Skip duplicate elements for k
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println("the Optimal sol is: -"+OptimalApproach(arr));
    }
}
