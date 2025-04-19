package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question --> koko eating the bananas

public class koko_Eating_Bananas {
    /// this is the brute force approach
    /// time --> O( max (piles) * h ) ---> which will leads us to the time limit exceeded, so we have to Optimize it
    /// space --> O(1)
    static int CalculateTotalTime(int[] piles, int i){
        int tot = 0;
        int n = piles.length;
        for(int j=0; j<=n-1; j++){
            tot += Math.ceil( (double)(piles[j]) / (double)(i) );
        }
        return tot;
    }
    static int BruteApproach(int[] piles, int h){
        // first find the maximum element of the array bcz we know that my answer will lay in between then
        int n = piles.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<=n-1; i++){
            if (piles[i] > maxi){
                maxi=piles[i];
            }
        }

        // new compute the total time taken by each speed
        for(int i=1; i<=maxi; i++){
            int totalTime = CalculateTotalTime(piles, i);
            if (totalTime <= h){
                return i;
            }
        }
        return maxi;
    }






    ///  this is the Optimal Approach by using the Binary Search
    /// time --> O( n * log (max(piles)) )
    /// space --> O(1)
    static int CalculateTime(int[] piles, int mid){
        int n = piles.length;
        int totalH =0;
        for(int i=0; i<=n-1; i++){
            totalH += Math.ceil( (double)(piles[i]) / (double)(mid) );
        }
        return totalH;
    }
    static int OptimalSolution(int[] piles, int h){
        int n = piles.length;
        // find the max element first , because we know that the range is [1.....max(piles)] , within this our answer will lie
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<=n-1; i++){
            if(piles[i] > maxi) maxi = piles[i];
        }

        // now do the Binary Search Instead of Linear Search to avoid the Time Limit Exceeded
        int low = 1;
        int high = maxi;
        while(low <= high){
            int mid = low + (high - low)/2;
            int TotalTime = CalculateTime(piles, mid);
            if(TotalTime <= h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(OptimalSolution(piles, h));
    }
}
