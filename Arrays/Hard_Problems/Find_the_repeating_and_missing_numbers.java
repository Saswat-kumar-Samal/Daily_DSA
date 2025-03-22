package Daily_DSA.Arrays.Hard_Problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// Question - Find the repeating and missing numbers in the array

public class Find_the_repeating_and_missing_numbers {
    /// this is the brute approach
    /// time --> O(n^2)
    /// space --> O(1)
    static ArrayList<Integer> BruteApproach(int[] arr){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1; i<=n; i++){
            int cnt=0;
            for(int j=0; j<=n-1; j++){
                if (i == arr[j]){
                    cnt++;
                }
                if (cnt == 2) ans.add(arr[j]);
            }
            if (cnt==0){
                ans.add(i);
            }
        }
        return ans;
    }


    ///  this is the better approach by using the hashmap
    /// time --> O(2n)
    /// space --> O(1) for using a hash array for algo
    static ArrayList<Integer> BetterApproach(int[] arr){
        int n = arr.length;
        int missing=-1,repeating=-1;
        int[] hash = new int[n+1];
        for(int i=0; i<=n-1; i++){
            hash[arr[i]]++;
        }
        for(int i=1; i<=hash.length-1; i++){
            if (hash[i] == 2) repeating=i;
            else if (hash[i] == 0) missing =i;
            if (missing == -1 && repeating == -1){
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(repeating,missing));
        return ans;
    }



    ///  this is the Optimal solution using the simple basic maths
    /// time -->
    /// space -->
    static ArrayList<Integer> OptimalSol(int[] arr){
        long n = arr.length;
        // s - sn (x-y)
        // s2 - s2n (x2 - y2) = (x+y)(x-y)
        long sn = (n * (n+1))/2;
        long s2n = (n * (n+1) * (2 * n +1))/6;
        long s=0; long s2=0;
        for(int i=0; i<=n-1; i++){
            s += arr[i];
            s2 += (long)Math.pow(arr[i],2);
        }
        long val1 = s - sn;
        long val2 = s2 - s2n;
        val2 = val2/val1;
        long x = (val2 + val1)/2;
        long y = x - val1;
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList((int)x,(int)y));
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {4,3,6,2,1,1};
        System.out.println(OptimalSol(arr));
    }
}
