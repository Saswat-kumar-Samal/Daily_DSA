package Daily_DSA.Arrays.Medium_Problem;

import java.util.ArrayList;
import java.util.Arrays;

public class Leaders_In_Array {

    ///  this is the brute force approach
    /// time --> nearly O(n^2) not exactly O(n)
    /// space --> O(n) in worst case in order to return the answer
    static ArrayList<Integer> BruteApproach(int[] nums){
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0 ; i<=n-1; i++){
            boolean leader = true;
            for (int j=i; j<=n-1; j++){
                if (nums[j] > nums[i]){
                    leader = false;
                    break;
                }
            }
            if (leader){
                ans.add(nums[i]);
            }
        }
        return ans;
    }




    ///  this is Optimal Solution
    /// time --> O(n)
    /// space --> O(1)
    static ArrayList<Integer> OptimalSolution(int[] nums){
        ArrayList<Integer> ans = new ArrayList<>();
        int n =nums.length;
        int max=Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--){
            if (nums[i] > max){    // every time I have to keep a track of max element of the right side
                max = nums[i];
            }
            if (nums[i] >= max){
                ans.add(nums[i]); // if the element is grater than max element , that means it is grater than all the elements of it's right
            }
        }
        return ans;

    }



    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3 , 0 ,6};
        //int[] nums = {17,18,5,4,6,1};
        for (int ele : OptimalSolution(nums)){
            System.out.print(ele+" ");
        }
    }
}
