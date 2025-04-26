package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question --> Aggressive Cows (GeeksForGeeks)
///                here we have another pattern min(max) or max(min)

import java.util.Arrays;
public class Aggressive_Cows {
    /// this is the Brute Force Approach by linear search
    /// time --> O( (max - min) * n  + n log n )   it is nearly a Quadratic time (n^2) complexity
    /// space --> O(1)
    static boolean CanWePlace(int[] arr, int minDist, int k){
        int n = arr.length;
        int cntCows=1; int last = arr[0];
        for(int i=1; i<=n-1; i++){
            if(arr[i] - last >= minDist){
                cntCows++;
                last = arr[i];
            }
            if (cntCows >= k) return true;
        }
        return false;
    }
    static int BruteSolution(int[] arr, int k){
        int n = arr.length;
        Arrays.sort(arr);    // - n * log n

        for(int minDist = 1; minDist <= (arr[n-1] - arr[0]); minDist++){ // total time -- O(max - min) * n
            if(CanWePlace(arr, minDist, k)){
                continue;
            }else{
                return (minDist-1);
            }
        }
        return -1;
    }




    ///  this is the Optimal Solution by using the Binary search
    /// time --> O( n * log n  + n * log (max - min) )
    /// space --> O(1)
    static int OptimalSolution(int[] arr, int k){
        int n = arr.length;
        Arrays.sort(arr);

        int low=1; int high=(arr[n-1] - arr[0]);
        while(low <= high){
            int mid = low + (high - low)/2;
            if(CanWePlace(arr, mid, k)) low=mid+1;
            else high=mid-1;
        }
        return high;  // because high variable will ends of with our answer
    }
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 5}; int k =3;
        System.out.println(BruteSolution(arr, k));
    }
}
