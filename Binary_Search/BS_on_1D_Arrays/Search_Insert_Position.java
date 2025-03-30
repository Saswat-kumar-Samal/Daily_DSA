package Daily_DSA.Binary_Search.BS_on_1D_Arrays;

///  Question --> search insert position means there is a number k , if the number k is present in the array
///               return the index , and is not present then return the index where it should be so that
///               the array maintain the sorted order

public class Search_Insert_Position {
    ///  this can be done by using the lower bound concept of binary search
    /// time --> O(log n)
    /// space --> O(1)
    static int SearchInsertPos(int[] arr, int k){
        int n = arr.length;
        int low=0,high=n-1;
        while (low <= high){
            int mid =(low+high)/2;
            if (arr[mid] == k){
                return mid;
            } else if (arr[mid] > k) {
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int k = 2;
        System.out.println(SearchInsertPos(arr,k));
    }
}
