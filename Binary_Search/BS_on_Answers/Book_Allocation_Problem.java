package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question --> book allocation problem (extremely hard Question on binary search on answers)


public class Book_Allocation_Problem {
    /// this is the Brute Force Approach
    /// time --> O( (sum-max+1) * n )
    /// space --> O(1)
    static int MaxPages(int[] arr, int pages){
        int n = arr.length;
        int cntStudents=1; int currPages=0;
        for(int i=0; i<=n-1; i++){
            if (currPages + arr[i] <= pages){
                currPages += arr[i];
            }else{
                cntStudents++;
                currPages=arr[i];
            }
        }
        return cntStudents;
    }
    static int BruteSolution(int[] arr ,int k){
        int n = arr.length;
        if (k > n) return -1;
        int maxi=Integer.MIN_VALUE; int sum =0;
        for(int i=0; i<=n-1; i++){
            maxi = Math.max(maxi, arr[i]);
            sum += arr[i];
        }

        for(int i=maxi; i<=sum; i++){
            int cntStu = MaxPages(arr, i);
            if (cntStu == k) return i;
        }
        return -1;
    }









    ///  this is the Optimal Solution by Binary search
    /// time --> O( log (sum-max+1) * n)
    /// space --> O(1)
    static int OptimalSolution(int[] arr, int k){
        if(k > arr.length) return -1;
        int maxi=Integer.MIN_VALUE; int sum=0;
        for(int i=0; i<arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
            sum += arr[i];
        }

        int low = maxi; int high = sum;
        while(low <= high){
            int mid = low + (high - low)/2;
            int cntStu = MaxPages(arr, mid);
            if(cntStu > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(OptimalSolution(arr, k));
    }
}
