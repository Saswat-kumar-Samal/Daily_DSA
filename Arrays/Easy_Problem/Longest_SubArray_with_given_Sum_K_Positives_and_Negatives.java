package Daily_DSA.Arrays.Easy_Problem;

import java.util.HashMap;
import java.util.Map;

public class Longest_SubArray_with_given_Sum_K_Positives_and_Negatives {

    /// very naive approach
    /// time --> nearly O(n^2)
    /// space --> O(1)

    static int NaiveApproach(int[] arr, int K){
        int n =arr.length;
        int maxLen =0;
        for (int i=0; i<=n-1; i++){
            int sum =0;
            for (int j=i; j<=n-1; j++){
                sum+=arr[j];
                if (sum==K) maxLen = Math.max(maxLen , j-i+1);
            }
        }
        return maxLen;
    }



    /// optimal solution
    /// time --> O(n)
    ///  space --> O(n)
    static int OptimalSolution(int[] arr , int K){
        Map<Long , Integer> preFixSum = new HashMap<>();
        int n =arr.length;
        long sum=0;
        int maxLen =0;
        for (int i=0; i<=n-1; i++){
            sum += arr[i];
            if (sum == K){
                maxLen = Math.max(maxLen , i+1);
            }

            if (!preFixSum.containsKey(sum)){
                preFixSum.put(sum,i);
            }
            long rem = sum - K;
            if (preFixSum.containsKey(rem)){
                int len = i - preFixSum.get(rem);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {-1, 1, 1,2,1};
        int K=3;
        System.out.println(OptimalSolution(arr,K));
    }
}
