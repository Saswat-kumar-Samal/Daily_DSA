package Daily_DSA.Binary_Search.BS_on_1D_Arrays;


///  Question --> Search Single Element in a sorted array



public class Search_Single_Element_In_a_Sorted_Array {
    ///  this is the brute approach 1 by using the Xor
    /// time --> O(n)
    /// space --> O(1)
    static int BruteApproach(int[] arr){
        int n = arr.length;
        int ans = arr[0];
        for (int i=1; i<=n-1; i++){
            ans ^= arr[i];
        }
        return ans;
    }

    ///  this is brute approach 2
    /// time --> O(n)
    /// space --> O(1)
    static int BruteApproach2(int[] arr){
        int n = arr.length;
        if (n == 1) return arr[0];
        for (int i=0; i<= n-1; i++){
            if (i == 0) {
                if (arr[i] != arr[i+1]) return arr[i];
            } else if (i == n-1) {
                if (arr[i] != arr[n-1]) return arr[i];
            }else{
                if (arr[i] != arr[i-1] && arr[i] != arr[i+1]) return arr[i];
            }
        }
        return -1;
    }


    ///  this is Optimal Approach by using the Binary search
    /// time --> O(log n)
    /// space --> O(1)
    static int OptimalSolution(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low=1; int high=n-2;
        while(low <= high){
            int mid = low + (high - low)/2;
            if((nums[mid] != nums[mid-1]) && (nums[mid] != nums[mid+1])) return nums[mid];
            else if((mid % 2 == 1 && nums[mid] == nums[mid-1]) || (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,6,6,11,11};
        System.out.println(BruteApproach2(arr));
    }
}
