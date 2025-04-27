package Daily_DSA.Binary_Search.BS_on_Answers;

/// Question --> split Array Largest Sum ( hard Question )
///        similar Question like Book Allocation problem


public class Split_Array_Largest_Sum {
    ///  this is the Optimal Approach
    /// time --> O( log (sum-max+1) * n)
    /// space --> O(1)
    static int CountSubArrays(int[] nums, int maxSum) {
        int cntSubarrays = 1;
        long sum = 0;
        for (int ele : nums) {
            if (sum + ele <= maxSum) {
                sum += ele;
            } else {
                cntSubarrays++;
                sum = ele;
            }
        }
        return cntSubarrays;
    }

    static int OptimalSolution(int[] nums, int k){
        int n = nums.length;
        int low = nums[0];
        int high = 0;
        for (int ele : nums) {
            low = Math.max(low, ele);
            high += ele;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int NoOFSubArray = CountSubArrays(nums, mid);
            if (NoOFSubArray > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int k = 2;
        System.out.println(OptimalSolution(arr, k));
    }
}
