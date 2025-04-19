package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question - Finding Sqrt of a number using Binary Search

public class Finding_Sqrt_of_a_number_using_Binary_Search {
    ///  this is the brute force approach by using the linear search
    /// time --> O(n)
    /// space --> O(1)
    static int BruteApproach(int num){
        int ans = 1;
        for(int i=1; i <= num; i++){
            if (i*i <= num){
                ans = i;
            }else {
                break;
            }
        }
        return ans;
    }


    ///  this is the Optimal Approach by using the Binary search
    /// time --> O(log n)
    /// space --> O(1)
    static int OptimalAns(int num){
        int low = 1,high=num;
        int ans = 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if((long) mid * mid <= num){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        System.out.println(BruteApproach(10000000));
    }
}
