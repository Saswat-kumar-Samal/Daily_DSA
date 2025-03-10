package Daily_DSA.Arrays.Medium_Problem;

///  Question - Count Sub array sum Equals K

import java.util.*;
public class Count_SubArray_sum_Equals_K {
    ///  this is the brute approach
    /// time --> O(n^2)
    /// space --> O(1)
    static int BruteApproach(int[] nums , int k){
        // generate all the sub arrays and count the sub arrays
        int n = nums.length;
        int cnt=0;
        for(int i=0; i<=n-1; i++){
            int sum =0;
            for(int j=i; j<=n-1; j++){
                sum += nums[j];
                if (sum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }


    ///  this is the Optimal Approach by using prefix concept
    /// time ---> O(n)
    /// space --> O(n) for every distinct sum that we have stored
    static int OptimalSolution(int[] arr, int k){
        int n = arr.length; // size of the given array.
        Map<Integer , Integer> mpp = new HashMap();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of sub arrays to be removed:
            if (mpp.containsKey(remove)){
                cnt += mpp.get(remove);
            }

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,-3,1,1,1,4,2,-3};
        int k =3;
        System.out.println(BruteApproach(nums,k));
    }
}
