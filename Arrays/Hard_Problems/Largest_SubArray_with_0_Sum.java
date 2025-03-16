package Daily_DSA.Arrays.Hard_Problems;

///  Question --> you are given an array , you have to give the longest sub array whose sum is equals 0

import java.util.*;
public class Largest_SubArray_with_0_Sum {
    ///  this is brute approach by generating all the sub arrays by using the for loops
    /// time --> O(n^2)
    /// space --> O(1)
    static int BruteApproach(int[] arr){
        int n = arr.length;
        int maxLen = 0;
        for(int i=0; i<=n-1; i++){
            int sum=0;
            for(int j=i; j<=n-1; j++){
                sum += arr[j];
                if(sum == 0) maxLen = Math.max(maxLen , j-i+1);
            }
        }
        return maxLen;
    }



    ///  this is the Optimal Approach by using hashing  , it is little bit like the 'longest sub array with given sum k'
    ///  by using prefix sum method , but not exactly

    /// time --> O(n)
    /// space --> O(n) for using the MAP
    static int OptimalSolution(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int longest =0;
        int sum =0;
        for(int i=0; i<=n-1; i++){
            sum += arr[i];
            if(sum == 0){  // if sum is 0 that means upto 0 index to till that index is the length of the sum array
                longest = Math.max(longest , i+1);
            }else{
                if(map.containsKey(sum)){ // if the map contains the sum that means the prefix sum is 'sum' means current sum is 0
                    longest = Math.max(longest , i - map.get(sum)); // so the length will be current index - the index where initially sum had appeared
                }else{
                    map.put(sum,i); // if it is not in the map just put it with it's index
                }
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] arr = {1,-1,3,2,-2,-8,1,7,10,23};
        System.out.println(OptimalSolution(arr));
    }
}
