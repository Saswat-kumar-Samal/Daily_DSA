package Daily_DSA.Binary_Search.BS_on_Answers;


///  Question --> finding the kth element of the sorted array

public class Kth_element_Of_2_Sorted_Array {
    ///  this is the Optimal Solution we are using the concept of "Median of 2 sorted array"
    /// time --> O(log(n1,n2));
    /// space --> O(1)
    static int OptimalApproach(int[] a, int[] b, int k){
        int n1 = a.length;
        int n2 = b.length;
        if(n1 > n2) return OptimalApproach(b, a, k);
        int left = k;
        int low = Math.max(0, k - n2);
        int high = Math.min(k , n1);
        while(low <= high){
            int mid1 = (low + high ) >> 1;
            int mid2 = left - mid1;
            int l1 = (mid1 - 1 >= 0) ? a[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1 >= 0) ? b[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
