package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question -- minimum no of days required to make m bouquet

public class Minimum_days_to_make_M_bouquets {
    ///  this is the brute Approach
    /// time --> O( (max-min+1) * n )  it may lead to the TLE (time limit exceeded)
    /// space --> O(1)
    static boolean Possible(int[] BloomDay, int day, int n, int m ){
        int cnt =0;
        int noOfB=0;
        int len=BloomDay.length;
        for (int i=0; i<=len-1; i++){
            if (BloomDay[i] <= day) cnt++;
            else{
                noOfB += (cnt/m);   // no of bouquets
                cnt=0;
            }
        }
        noOfB += (cnt/m);  // at the end of the day you have to calculate the no of bouquets required
        return noOfB >= n;
    }
    static int[] FindMinMax(int[] BloomDay, int len){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<=len-1; i++){
            if (BloomDay[i] > max) max = BloomDay[i];
            else if (BloomDay[i] < min) min = BloomDay[i];
        }
        return new int[]{min,max};
    }
    static int BruteApproach(int[] BloomDay, int n, int m){
        int len = BloomDay.length;
        if (len < m * n) return -1;
        int[] MinMax = FindMinMax(BloomDay, len);
        int min = MinMax[0]; int max=MinMax[1];

        // find the possible day
        for(int day=min; day<= max; day++){
            if (Possible(BloomDay ,day, n , m )){
                return day;
            }
        }
        return -1;
    }






    ///  this is the Optimal Approach by using the Binary search
    /// time -->
    /// space -->
    static int OptimalApproach(int[] BloomDay, int n , int m){
        int len = BloomDay.length;
        if (len < m * n) return -1;
        int low = FindMinMax(BloomDay, len)[0];
        int high = FindMinMax(BloomDay, len)[1];
        int ans = 0;

        // we can simply optimize this by using the Binary search bcz we know the range and
        // also know which portion is possible and which portion is not possible
        while(low <= high){
            int mid = low + (high - low)/2;
            if (Possible(BloomDay, mid, n ,m)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] BloomDay = {1,10,3,10,2};
        int m=3; int K=1;
        System.out.println(OptimalApproach(BloomDay, m, K));
    }
}
