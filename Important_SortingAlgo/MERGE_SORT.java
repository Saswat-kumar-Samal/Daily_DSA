package Daily_DSA.Important_SortingAlgo;


// mergesort is taking O(nlogn) to sort the array
// it takes the divide and conquer technique
// time complexity is :- O(nlogn)
// space complexity is :- O(n) for using a temporary array


import java.util.*;
public class MERGE_SORT {
    static void merge(int[] arr,int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;      // staring index of left half array
        int right = mid+1;   // starting index of right half array

        while(left<=mid && right<=high){
            if (arr[left] < arr[right]) {temp.add(arr[left]); left++;}
            else {temp.add(arr[right]); right++;}
        }
        // if any element left in the left array;
        while (left<=mid) {temp.add(arr[left]); left++;};
        // if any element left in the right array
        while (right<=high){temp.add(arr[right]); right++;}
        //then transfer all the element from temp array to original array
        for(int i=low;i<= high;i++){
            arr[i] = temp.get(i-low);
        }
    }
    static void mergesort(int[] arr,int low ,int high){
        if (low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergesort(arr, mid+1, high);
        mergesort(arr, low, mid);
        merge(arr,low,mid,high);
    }
    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        int low =0; int high= arr.length-1;
        mergesort(arr,low,high);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }
}
