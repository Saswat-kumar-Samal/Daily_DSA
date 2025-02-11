package Daily_DSA.Arrays.Easy_Problem;


///  check the array is sorted or not
/// we are assuming that only ascending order soring is needed


import  java.util.*;
public class CheckIfTheArrayIsSorted {

    ///  very naive approach
    /// tc -> O(nlogn)
    /// sc -> O(n) for using another array  for comparing
    static boolean BruteApproach(int[] arr){
        int n = arr.length;
        int[] temparr = new int[n];
        for (int i=0;i<=n-1;i++){
            temparr[i]=arr[i];
        }
        Arrays.sort(temparr);
        boolean isSorted = true;
        for (int i=0;i<=n-1;i++){
            if (temparr[i] != arr[i]){
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }


    /// optimal approach
    /// tc -> o(n)
    /// sc -> O(1)
    static boolean OptimalIsSorted(int[] arr){
        int n =arr.length;
        for(int i=1;i<=n-1;i++){
            if (arr[i] < arr[i-1]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {6,1,2,2,3,5};
        System.out.println(OptimalIsSorted(arr));
    }
}
