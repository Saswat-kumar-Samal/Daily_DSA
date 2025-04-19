package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question -- You are given 2 numbers n and m,
///              the task is to find n√m (nth root of m). If the root is not integer then returns -1.

public class Nth_Root_Of_Integer {
    ///  this is the brute Approach by linear search
    /// time --> O(m * n)
    /// space -->O(1)
    static int func(int i, int n){
        int num = 1;
        for(int point = 0; point < n; point++){
            num *= i;
        }
        return num;
    }
    static int BruteApproach(int n , int m){
        int ans = -1;
        for(int i=0; i<=m; i++){
            if(func(i, n) == m){
                return i;
            } else if (func(i, n) > m) {
                break;
            }
        }
        return -1;
    }


    ///  this is the Optimal Approach by using the binary search
    /// time --> O(log m * n) = O(n * lon m)
    /// space -->O(1)
    static int midpowern(int mid , int n, int m){
        long ans =1;
        for(int i=0; i<n; i++){
            ans *= mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
    static int OptimalApproach(int n, int m){
        int low=1,high=m;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(midpowern(mid, n, m) == 1) return mid;
            else if(midpowern(mid, n, m) == 0) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(BruteApproach(4,69));
    }
}
