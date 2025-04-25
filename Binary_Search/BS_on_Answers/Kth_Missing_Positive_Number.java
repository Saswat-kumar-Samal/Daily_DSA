package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question --> kth missing positive number

public class Kth_Missing_Positive_Number {
    ///  this is the brute solution by traversing the whole array
    /// time --> O(n)
    /// space --> O(1)
    static int BruteApproach(int[] arr, int k){
        int n =arr.length;
        for(int i=0; i<=n-1; i++){
            if(arr[i] <= k) k++;
            else break;
        }
        return k;
    }



    ///  this is the Optimal Approach by using Binary Search
    /// time --> O( log n )
    /// space --> O(1)
    static int OptimalSolution(int[] arr, int k){
        int n =arr.length;
        int low=0;int high=n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int missing = arr[mid] - (mid+1); // finding the missing number which by subtracting the current element and the ideal no which should be occupied
            if(missing < k) low = mid+1;
            else high=mid-1;
        }
        return (high+1+k); // this is the formula we derived to return the missing number
    }



    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(BruteApproach(arr, k));
    }
}
