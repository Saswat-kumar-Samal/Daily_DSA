package Daily_DSA.Binary_Search.BS_on_Answers;

///  Questions --> The Least capacity to ship package in D days


public class Least_Capacity_To_Ship_Packages_In_D_Days {
    ///  this is the Brute Approach
    /// time --> O((sum - max) * n)
    /// space -->O(1)

    // I need to figure out the range of capacity of ship so that I can ship all the weight present in the array
    // so I know that I can not take the capacity can not be less than max(arr) bcz if I take then i will not able
    // to put that weight into the ship and max to max i can take capacity of all total weight. the range is
    // ------> [max(arr)......sum(arr)] between this range our answer will be lay;
    static int Days(int[] arr, int capacity){
        int n = arr.length;
        int days = 1;int load=0;  // here day should start from 1 because we are assuming that at least 1 day require
        for(int i=0; i<=n-1; i++){
            load += arr[i];
            if (load > capacity){
                days++; load=0;
                i--;
            }
        }
        return days;
    }
    static int BruteApproach(int[] arr, int days){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<=n-1; i++){
            maxi = Math.max(maxi, arr[i]);
            sum += arr[i];
        }

        for(int capacity=maxi; capacity<=sum; capacity++){
            if(Days(arr, capacity) <= days){
                return capacity;
            }
        }
        return -1;
    }





    ///  this is the Optimal Approach using Binary search
    /// time --> O(log(sum - max) * n)
    /// space -->O(1)
    static int DaysReq(int[] weights, int capacity){
        int n = weights.length;
        int days=1; int load=0;
        for(int i=0; i<=n-1; i++){
            if(load + weights[i] > capacity){
                days++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }
    static int OptimalApproach(int[] weights, int days){
        int n = weights.length;
        int maxi = Integer.MIN_VALUE; int sum=0;
        for(int i=0; i<=n-1; i++){
            maxi = Math.max(maxi, weights[i]);
            sum += weights[i];
        }

        int low = maxi; int high = sum;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(DaysReq(weights, mid) <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,2,4,1,4};
        int days = 3;
        System.out.println(BruteApproach(arr, days));
    }
}
