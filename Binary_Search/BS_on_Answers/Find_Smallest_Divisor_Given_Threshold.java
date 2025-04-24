package Daily_DSA.Binary_Search.BS_on_Answers;

///  Ques --> to find the smallest divisor to a given threshold

public class Find_Smallest_Divisor_Given_Threshold {
    ///  this is the Brute Approach using linear search
    /// time --> O( max(arr) * n )
    /// space --> O(1)
    static int BruteApproach(int[] arr, int threshold){
        int n = arr.length;
        // I know that answer will lay between in the range of [1....max(arr)]
        // we can not divide any number less than 0 and also there is no sense of dividing a number more than
        // max of array's element bcz all the number more than max of array's element will give you same sum
        // as the max element will give you so our range is --> [1 ... max(arr)]

        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<=n-1; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        for(int divisor=1; divisor<=maxi; divisor++){
            int sum=0;
            for(int j=0; j<=n-1; j++){
                sum += (int) Math.ceil( (double) arr[j]/divisor);
            }
            if (sum <= threshold) return divisor;
        }
        return -1;
    }




    ///  this is the Optimal Approach by using the Binary search
    /// time --> O( log(max(arr)) * n)
    /// space --> O(1)
    static int SumOfD(int[] nums, int div){
        int n = nums.length;
        int sum = 0;
        for (int i=0; i<=n-1; i++){
            sum += (int) Math.ceil( (double)nums[i]/ (double)div);
        }
        return sum;
    }
    static int OptimalSolution(int[] nums, int threshold){
        int n  = nums.length;
        int maxi=Integer.MIN_VALUE;
        for (int i=0; i<=n-1; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        int low = 1;
        int high = maxi;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(SumOfD(nums, mid) <= threshold){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,9}; int threshold = 6;
        System.out.println(OptimalSolution(arr, threshold));
    }
}
