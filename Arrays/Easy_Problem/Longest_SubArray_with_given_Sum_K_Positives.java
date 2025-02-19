package Daily_DSA.Arrays.Easy_Problem;

import java.util.HashMap;
import java.util.Map;

///  Question --> Longest SubArray with given Sum K ( containing only Positives elements )



public class Longest_SubArray_with_given_Sum_K_Positives {


    /// very naive approach
    /// time complexity is --> O( n^2 )
    /// space complexity is :--> O(1)
    static int Sum_kBruteApproach(int[] arr , int K){
        int n = arr.length;
        int len=0;
        for (int i=0; i<=n-1; i++){
            int sum=0;
            for (int j=i; j<=n-1; j++){
                // now find the sum from 'i' to 'j' by a for loop
                sum += arr[j];
                if (sum==K) len= Math.max(len , (j-i+1));
            }
        }
        return len;
    }




    ///  this is the better approach by using hashing
    /// time --> O(n)
    /// space --> O(n) for using the hash map
    static int Sum_KBetterApproach(int[] arr ,long K){
        Map<Long,Integer> preFixSum = new HashMap<>();
        int n  =arr.length;
        long sum=0;
        int MaxLen =0;
        for (int i=0;i<=n-1; i++){
            sum += arr[i];

            if (sum == K){
                MaxLen = Math.max(MaxLen , i+1);
            }

            long rem = sum -K;
            if (preFixSum.containsKey(rem)){
                int len = i - preFixSum.get(rem);
                MaxLen = Math.max(MaxLen , len);
            }

            if (!preFixSum.containsKey(sum)){
                preFixSum.put(sum, i);
            }
        }
        return MaxLen;
    }




    ///  this is the optimal solution
    /// time --> O(n)
    /// space --> O(1)
    static int OptimalSolution(int[] arr ,int K){
        int n =arr.length;
        int maxLen=0;
        int sum=arr[0];

        ///  initialize 2 pointers
        int i=0;int j=0;
        while (j < n){
            while (i<=j && sum > K){
                sum -= arr[i];
                i++;
            }
            if (sum == K) maxLen = Math.max(maxLen , j-i+1);
            j++;
            if (j < n) sum+=arr[j];
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {2,0,0,3};
        int K = 3;
        System.out.println("the optimal solution is :- "+OptimalSolution(arr,K));
    }
}
