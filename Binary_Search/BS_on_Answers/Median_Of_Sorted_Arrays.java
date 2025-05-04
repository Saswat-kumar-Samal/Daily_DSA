package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question --> to find the median of two sorted Array


public class Median_Of_Sorted_Arrays {
    /// this is the brute force Approach
    /// time --> O( m+n )
    /// space -->O(m+n)
    static double BruteSolution(int[] arr1, int[] arr2){
        // it can be solved if I merge this 2 arrays into third array
        int[] third = new int[arr1.length+arr2.length];
        int i=0,j=0;
        int k=0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                third[k++] = arr1[i++];
            }else{
                third[k++] = arr2[j++];
            }
        }
        while(i<arr1.length){
            third[k++] = arr1[i++];
        }
        while (j < arr2.length){
            third[k++] = arr2[j++];
        }


        // let's check if the length is even or odd
        int totLen = (arr1.length + arr2.length);
        double median=0;
        if (totLen%2 == 0){
            median = (double) (third[totLen/2] + third[(totLen/2)-1])/2;
        }else{
            median = (double) third[totLen/2];
        }
        return median;
    }



    ///  this is the Optimal Solution
    /// time --> O(log(min(n1,n2)))
    /// space --> O(1)
    static double OptimalSolution(int[] nums1, int[] nums2){
        int n1 = nums1.length, n2 = nums2.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return OptimalSolution(nums2, nums1);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }
    public static void main(String[] args) {

    }
}
