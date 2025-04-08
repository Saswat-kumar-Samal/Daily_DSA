package Daily_DSA.Binary_Search.BS_on_1D_Arrays;

///  Questions --->  Given an array of length N. Peak element is defined as the element greater than both of its neighbors.
///                 Formally, if 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.
///                 Find the index(0-based) of a peak element in the array. If there are multiple peak numbers,
///                 return the index of any peak number.


public class Find_Peak_Element_In_Array {
    /// this is brute approach by linear search
    /// time --> O(n)
    /// space --> O(1)
    static int BruteApproach(int[] nums){
        int n = nums.length;
        for(int i=0; i<=n-1; i++){
            if(i == 0) {
                if(nums[i] > nums[i+1]) return i;
            }else if(i == n-1){
                if(nums[n-1] > nums[n-2]) return i;
            }else{
                if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
            }
        }
        return -1;
    }


    ///  this is the Optimal Approach by using the binary search
    /// time --> O(log n)
    /// space --> O(1)
    static int OptimalSolution(int[] nums){
        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        int low=1,high=n-2;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] > nums[mid-1]){
                low = mid+1;

            }else if(nums[mid] > nums[mid+1]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,1,2,1};
        System.out.println(OptimalSolution(arr));
    }
}
