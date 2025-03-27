package Daily_DSA.Binary_Search.BS_on_1D_Arrays;

public class Binary_Search_to_find_X_in_sorted_array {
    static int BinarySearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(arr[mid] == k) ans = mid;
            if(arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3,3,3,3,4,4,4,5,5,5};
        int k=3;
        System.out.println(BinarySearch(arr,k));
    }
}
