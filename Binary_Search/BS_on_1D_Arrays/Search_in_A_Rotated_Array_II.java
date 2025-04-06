package Daily_DSA.Binary_Search.BS_on_1D_Arrays;

///  Question - > Given an integer array arr of size N, sorted in ascending order (may contain duplicate values)
///         and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is
///          present and otherwise, return False.


///  it is similar question like 'search in a rotated sorted array - I' but contains duplicates

public class Search_in_A_Rotated_Array_II {
    /// this is the brute approach by using linear search
    /// time --> O(n)
    /// space --> O(1)
    static boolean BruteApproach(int[] arr, int k){
        int n  = arr.length;
        for (int i=0; i<=n-1; i++){
            if (arr[i] == k){
                return true;
            }
        }
        return false;
    }



    ///  this is the optimal Approach by using the Binary search
    /// time -->
    /// space -->
    static boolean OptimalSolution(int[] nums ,int target){
        int n = nums.length;
        int low=0, high=n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){ // this is the main condition that is failing for unique elements
                low++;                                             // when low , mid , high element will same we have to shrink the search space , so that we will not get duplicates further
                high--;
                continue;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
