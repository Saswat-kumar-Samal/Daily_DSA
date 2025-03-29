package Daily_DSA.Binary_Search.BS_on_1D_Arrays;

///  lower bound -- smallest index such that arr[idx] >= x

public class Implement_lowerBound {
    ///  this is the brute solution
    /// time --> O(n)
    /// space --> O(1)
    static int BruteApproach(int[] arr , int x){
        // the brute approach is linear search
        int n = arr.length;
        for (int i=0; i<=n-1; i++){
            if(arr[i] >= x){
                return i;
            }
        }
        return -1;
    }


    ///  this is the Optimal Approach by using the binary search
    /// time --> O(log n)
    /// space --> O(1)
    static int OptimalSolution(int[] arr, int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans=n;
        while (low <= high){
            int mid = (low+high)/2;
            if (arr[mid] >= x){
                ans = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }


    /// upper bound -- largest index such that arr[idx] > x
    /// this is similar as lower bound but little-bit different
    /// time --
    /// space --
    static int UpperBound(int[] arr, int x){
        int n = arr.length;
        int low=0,high=n-1,ans=n;
        while (low<=high){
            int mid = (low+high)/2;
            if (arr[mid] > x){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,7,8,9,9,9,11,11,15};
        int x  = 15;
        System.out.println(UpperBound(arr,x));
    }
}
