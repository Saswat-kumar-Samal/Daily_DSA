package Daily_DSA.Arrays.Medium_Problem;

public class Next_Permutation {

    ///  the brute force approach is very high time complexity so we are not going to implement it , for intitution just see the notes
    /// time -- nearly O(n! * n)
    /// space -- O(1)
    ///
    ///





    ///  this optimal solution
    /// time --  nearly  O(3n)
    /// space -- O(n) we are changing in the given array
    /// input arr = {2,1,5,4,3,0,0}
    /// output arr = {2 3 0 0 1 4 5}
    static void Reverse(int[] nums , int start , int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    static void nextPermutation(int[] nums) {
        int n = nums.length;
        // step - 1 --> find the longest prefix , means the break point
        int idx = -1;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                // index i is our break point
                idx = i;
                break;
            }
        }
        if(idx == -1){
            Reverse(nums , 0 , n-1);
            return;
        }

        // step - 2 find the number which is just grater than break point

        for(int i = n-1; i>=0; i--){
            if(nums[i] > nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // now reverse the right half , bez after swapping we do not need to sort it , it is needed to be
        // reverse
        Reverse(nums , idx+1 , n-1);
    }
    public static void main(String[] args) {
        int[] nums = {2,1,5,4,3,0,0};
        nextPermutation(nums);
        for (int ele : nums){
            System.out.print(ele+ " ");
        }
    }
}
