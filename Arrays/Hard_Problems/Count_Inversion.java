package Daily_DSA.Arrays.Hard_Problems;

// Question is --> you have given an array , the inversion will be i<j and a[i] > a[j]

public class Count_Inversion {
    ///  this is the brute force approach
    /// time -- O(n^2)
    /// space -- O(1)
    static int BruteApproach(int[] arr){
        int n = arr.length;
        int cnt=0;
        for (int i=0; i<=n-1; i++){
            for (int j=i+1; j<=n-1; j++){
                if (i<j && arr[i] > arr[j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }



    ///  this is the optimal solution
    /// time --
    /// space --
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        System.out.println(BruteApproach(arr));
    }
}
