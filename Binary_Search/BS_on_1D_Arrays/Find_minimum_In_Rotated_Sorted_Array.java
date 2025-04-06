package Daily_DSA.Binary_Search.BS_on_1D_Arrays;

///  Question --> Given an integer array arr of size N, sorted in ascending order (with distinct values).
///               Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array.


public class Find_minimum_In_Rotated_Sorted_Array {
    ///  this is the brute approach using the linear search
    /// time --> O(n)
    /// space --> O(1)
    static int BruteApproach(int[] arr){
        int n = arr.length;
        int mini = Integer.MAX_VALUE;
        for (int i=0; i<=n-1; i++){
            mini = Math.min(mini, arr[i]);
        }
        return mini;
    }



    ///  this is the Optimal Approach is Binary search
    /// time --> O(log n)
    /// space --> O(1)
    static int OptimalApproach(int[] nums){
        int n = nums.length;
        int low = 0, high=n-1;
        int mini = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;
            // first check the total array is sorted or not , if it is sorted then the nums[low] element will be always minimum
            if(nums[low] <= nums[high]){
                mini = Math.min(mini, nums[low]);
                break;  // we do not need to go further;
            }
            // left sorted part
            if(nums[low] <= nums[mid]){
                mini = Math.min(mini, nums[low]); // then minimum will the 'low' th index value
                low = mid+1;    // then we have to eliminate the left sorted part bez mini can be exist in the  right unsorted part
            }
            // right half is sorted
            else{
                mini = Math.min(mini, nums[mid]); // then the minimum is the 'mid' element can be minimum bez the sorted started from mid element
                high = mid-1;           // then we have to eliminate the right sorted part because minimum can be exist in the left unsorted part
            }
        }
        return mini;
    }
    public static void main(String[] args) {

    }
}
