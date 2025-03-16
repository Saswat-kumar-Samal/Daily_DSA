package Daily_DSA.Arrays.Hard_Problems;


///  Question --> 'Count the number of subArrays with given xor K'  means you are given an array and you have
///                to find the sub arrays who will give us a number k if all the elements get Xor with each other



import java.util.*;
public class Count_the_number_of_subArrays_with_given_xor_K {
    ///  this is brute approach by generating all the sub arrays by using the for loops
    /// time --> O(n^2)
    /// space --> O(1)
    static int BruteApproach(int[] arr , int k){
        int n =arr.length;
        int maxLen=0;
        int cnt=0;
        for(int i=0; i<=n-1; i++){
            int xor=0;
            for(int j=i; j<=n-1; j++){
                xor ^= arr[j];
                if(xor == k) cnt++;
            }
        }
        return cnt;
    }



    ///  this is the Optimal approach by using the hashmap and using like prefix sum technique , not the exactly sum similar to that
    /// time --> O(n)
    /// space --> O(n) for using the hashmap
    static int OptimalApproach(int[] arr, int k){
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int xr=0;
        int cnt=0;
        map.put(0,1); // this step is very important just like 'count the sub arrays with given sum k' Question
        for(int i=0; i<=n-1; i++){
            xr = xr ^ arr[i];
            // now I am looking for k , then how many times the x is appearing
            int x = xr ^ k;  // you have to find this element before which is x = xr ^ k
            if(map.containsKey(x)){
                cnt += map.get(x);
            }
            map.put(xr, map.getOrDefault(xr,0)+1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int k = 6;
        System.out.println(OptimalApproach(arr , k));
    }
}
