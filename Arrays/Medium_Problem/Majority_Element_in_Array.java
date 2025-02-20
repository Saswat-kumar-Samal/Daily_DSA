package Daily_DSA.Arrays.Medium_Problem;


/// Question --> you have to find the element in the array which is appearing more than n/2 times in the array ( n - length of the array)

import java.util.*;
public class Majority_Element_in_Array {



    /// this is a brut force approach
    /// time -> O(n^2)
    /// space --> O(1)
    static int BruteApproach(int[] arr){
        int n = arr.length;
        for (int i=0; i<=n-1 ;i++){
            int cnt=0;
            for (int j=0;j<=n-1;j++){
                if (arr[i] == arr[j]) cnt++;
            }
            if (cnt > n/2) return arr[i];
        }
        return Integer.MIN_VALUE;
    }



    ///  this is better solution by using the hashing
    /// time --> O(n) + O(n) -> O(2n)
    /// space --> O(n) for using hashing
    static int BetterApproach(int[] arr){
        int n =arr.length;
        Map<Integer , Integer> map = new HashMap<>();
        for (int i=0 ;i<=n-1; i++){  // ------> taking O(n)
            map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
        }

        // now iterating over the map and checking if there is number exist whose frequency is more than n/2 times
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){   // O(n) --> if any case the given array contains all unique elements
            if (entry.getValue() > n/2) return entry.getKey();
        }
        return Integer.MIN_VALUE;
    }




    ///  this is optimal solution by using moore's voting algorithm understand it very carefully
    /// time --> O(n) + O(n) this is for checking there is still exist the element or not
    /// space --> O(1)
    static int OptimalSolution(int[] arr){
        int n = arr.length;
        int cnt=0; int el=arr[0];
        for (int i=0; i<=n-1; i++){
            if (cnt==0){
                cnt=1;
                el =arr[i];
            }
            else if (arr[i] == el){
                cnt++;
            }else{
                cnt--;
            }
        }

        // after doing the algo you have to verify that , if there is still exist the majority element or not
        int count=0;
        for (int i=0; i<n-1; i++){
            if (arr[i] == el) count++;
        }
        if (count > n/2){
            return el;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,4,1,6,6,2,2};
        System.out.println("the majority element is :-> "+OptimalSolution(arr));
    }
}
