package Daily_DSA.Arrays.Medium_Problem;

import java.util.*;

///  Question -- Longest Consecutive Sequence in array



public class Longest_Consecutive_Sequence {

    ///  this is brute approach
    /// time --> O(n^2)
    /// space --> O(1)
    static boolean linearSearch(int[] nums, int key){
        int n =nums.length;
        for (int i=0; i<=n-1; i++){
            if (nums[i] == key){
                return true;
            }
        }
        return false;
    }
    static int BruteSolution(int[] nums){
        int n = nums.length;
        int Longest=1;
        for (int i=0; i<=n-1; i++){
            int x = nums[i];          // i will pick one by one element form array
            int cnt=1;        // if there is one element then cnt is always one
            while(linearSearch(nums, x+1)){ // i will check for x+1 element is present or not then , if present then increase the cnt
                x=x+1;
                cnt=cnt+1;
            }
            Longest = Math.max(Longest , cnt);
        }
        return Longest;
    }



    ///  this is the better solution by using soritng
    /// time --> O(n * log n) + O(n)
    /// space --> O(1)
    static int BetterSolution(int[] nums){
        Arrays.sort(nums);  // O(n * log n ) for sorting the array
        int n =nums.length;
        int Longest=1;
        int cntCurr=1;
        int lastSmaller = Integer.MIN_VALUE;
        for (int i=0; i<=n-1; i++){
            if (nums[i]-1 == lastSmaller){
                cntCurr +=1;
                lastSmaller =nums[i];
            }else if (nums[i] != lastSmaller){
                cntCurr=1;
                lastSmaller = nums[i];
            }
            Longest = Math.max(Longest , cntCurr);
        }
        return Longest;
    }



    /// this is the Optimal solution by using the set data structure
    /// time --> nearly O(3 * n)
    /// space --> O(n) for using the set data structure
    static int OptimalSolution(int[] nums){
        int n =nums.length;
        if(n==0){
            return 0; // if the length is 0 then answer is 0
        }
        int Longest =1;
        Set<Integer> set = new HashSet<>();

        // first put all the element in the set
        for(int i=0; i<=n-1; i++){
            set.add(nums[i]);
        }

        // then check for the elements
        int cnt=0;
        int x=0;
        for(int ele : set){
            if(!set.contains(ele-1)){  // if the previous element is not present in the set then only it can
                cnt =1;                // be the part the our sequence
                x = ele;
                while(set.contains(x+1)){
                    cnt += 1;
                    x += 1;
                }
            }
            Longest = Math.max(Longest , cnt);
        }
        return Longest;
    }
    public static void main(String[] args) {
        int[] nums = {102,4,100,1,101,3,2,1,1};
        System.out.println(BetterSolution(nums));
    }
}
