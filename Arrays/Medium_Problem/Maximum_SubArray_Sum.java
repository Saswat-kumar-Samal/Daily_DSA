package Daily_DSA.Arrays.Medium_Problem;

import java.util.ArrayList;
import java.util.Arrays;

///  Question --> find the maximum sub array sum inn the given array


public class Maximum_SubArray_Sum {
    /// this is the brute approach
    /// time --> O(n^2)
    /// space -->  O(1)
    static int BruteApproach(int[] arr){
        // we will generate all the sub arrays and try to find the maximum sum in between them
        int n=arr.length;
        int maxSum =Integer.MIN_VALUE; // we are declaring the lowest as possible bcz the max sum can be -ve number
        for (int i=0; i<=n-1; i++){
            int sum=0;
            for (int j=i; j<=n-1 ; j++){
                sum+=arr[j];
                maxSum = Math.max(maxSum , sum);
            }
        }
        return maxSum;
    }



    /// this is the most Optimal solution by using Kadane's algorithm , clearly understand it
    /// time --> O(n)
    /// space --> O(1)
    static long KadaneAlgo(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        int n =arr.length;
        int Sum=0;
        int start=0;
        int maxStart =-1 , maxEnd =-1;
        long maxi = Long.MIN_VALUE;
        for (int i=0; i<=n-1 ;i++){
            if (Sum ==0){
                start =i;
            }
            Sum += arr[i];
            if (Sum > maxi){
                maxi = Sum;
                maxStart = start; maxEnd=i;  // this is the tracking of the subArray that have the maximum sum
            }
            if (Sum < 0){     // you should not keep the negative sum to the future bcz it always decrease the sum in future , but we need the maximum
                Sum=0;
            }

        }
        if (maxi < 0){
            maxi =0;
        }

        System.out.print("the sub Array is :- [");
        for (int i = maxStart ; i<=maxEnd ; i++){   // this will be done if the interviewer will ask for which subArray is :-
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
        System.out.println();
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2 ,1,5,-3};
        //int[] arr = {-4,-3,-2,-1};
        System.out.println("the maximum sub Array sum is:- "+KadaneAlgo(arr));
    }
}
