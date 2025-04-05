package Daily_DSA.Binary_Search.BS_on_1D_Arrays;

/// Question --> Given an integer array arr of size N, sorted in ascending order (with distinct values) and a
///               target value k. Now the array is rotated at some pivot point unknown to you.
///                 Find the index at which k is present and if k is not present return -1.

public class Search_in_Rotated_Sorted_Array_I {
    /// this is the brute approach using the Linear search
    /// time --> O(n)
    /// space --> O(1)
    static int BruteApproach(int[] arr, int k){
        int n = arr.length;
        for(int i=0; i<=n-1; i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }



    ///  this is the optimal Approach by using the binary search
    /// time --> O(log n)
    /// space -->O(1)
    static int OptimalApproach(int[] nums, int target){
        int n = nums.length;
        int low=0, high=n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            //left half if sorted
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            // right half is sorted
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 8;
        int[] arr2 = {3,1};
        int target2 = 1;
        System.out.println(OptimalApproach(arr , target));
    }
}
