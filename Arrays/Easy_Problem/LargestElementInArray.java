package Daily_DSA.Arrays.Easy_Problem;


import java.util.*;
public class LargestElementInArray {
    static int BruteApproachLargerEle(int[] arr) {
        ///  sort the array and return the last guy sitting at the last
        ///  TC --> O(nlogn)  due to sort
        ///  sc --> O(1)

        Arrays.sort(arr);
        return arr[arr.length-1];
    }


    static int OptimalApproachLargestEle(int[] arr){
        /// keeping a large variable and updating it with the array element if larger
        /// TC --> O(n)  for running the loop one time
        /// sc --> O(1)

        int n =arr.length;
        int large = arr[0];
        for(int i=1;i <= n-1;i++){
            if (large<arr[i])
                large=arr[i];
        }
        return large;
    }
    public static void main(String[] args) {
        int[] arr = {5,7,9,2,3,10};
        System.out.println("the largest element in the array is :- "+OptimalApproachLargestEle(arr));
    }
}
