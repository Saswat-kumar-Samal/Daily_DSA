package Daily_DSA.Arrays.Hard_Problems;

/// Question - reverse pair --> hard question


import java.util.*;
public class Reverse_Pair {
    ///  this is the brute force approach
    /// time --> O(n^2)
    /// space --> O(1)
    static int BruteApproach(int[] arr){
        int n  = arr.length;
        int cnt=0;
        for (int i=0; i<=n-1; i++){
            for (int j=i+1; j<=n-1; j++){
                if (i<j && arr[i] > (2 * arr[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }



    ///  this is the optimal solution
    /// time --> O(2n * log n)
    /// space --> O(1)
    static int CountFun(int[] nums, int low, int mid ,int high){
        int cnt=0;
        int right=mid+1;
        for(int i=low; i<=mid; i++){
            while(right <= high && (long)nums[i] > 2L * nums[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
    static void Merge(int[] nums, int low, int mid ,int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left=low;
        int right=mid+1;
        // now merge it
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }

        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= high){
            temp.add(nums[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            nums[i] = temp.get(i - low);
        }
    }
    static int MergeSort(int[] nums, int low, int high){
        int cnt=0;
        if(low>=high){
            return cnt;
        }
        int mid = (low+high)/2;
        cnt += MergeSort(nums,low,mid);
        cnt += MergeSort(nums,mid+1,high);
        cnt += CountFun(nums,low,mid,high); // before mergeing the array we have to perform the count opration
        Merge(nums,low,mid,high);
        return cnt;
    }
    static int reversePairs(int[] nums) {
        int n = nums.length;
        return MergeSort(nums,0,n-1);
    }
    public static void main(String[] args) {
        int[] arr = {40,25,19,12,9,6,2};
        System.out.println(reversePairs(arr));
    }
}
