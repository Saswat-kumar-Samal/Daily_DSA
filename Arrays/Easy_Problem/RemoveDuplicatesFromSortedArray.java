package Daily_DSA.Arrays.Easy_Problem;

///  remove duplicates from a sorted array


import java.util.*;
public class RemoveDuplicatesFromSortedArray {
    ///  time complexity is :- O(nlogn) + O(n) bcz set takes O(logn) time to put element in itself
    /// space complexity is O(n) for using the set
    static int[] BruteApproachSolution(int[] arr){
        Set<Integer> set = new HashSet<>();
        int n =arr.length;
        for(int i=0;i<=n-1;i++){
            set.add(arr[i]);
        }
        int k = set.size();
        int j =0;
        arr = new int[n];
        for(int ele : set){
            arr[j++] = ele;
        }
        return arr;
    }



    /// time complexity is -> O(n)
    /// space complexity is -> O(1)
    static int OptimalApproach(int[] arr){
        int n = arr.length;
        int i=0;
        for (int j=0;j<= n-1;j++){
            if (arr[i]!=arr[j]){
                i++;             // first update the pointer then put the element in that position
                arr[i] = arr[j];
            }
        }
        return (i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3};
        System.out.println("after removing the element form the array is :-");
        System.out.println("the number of unique element is :- "+OptimalApproach(arr));
    }
}
