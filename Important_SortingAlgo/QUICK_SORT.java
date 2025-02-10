package Daily_DSA.Important_SortingAlgo;



// quick sort algorithm uses the divide and conquer technique
// time complexity is :- O(nlogn)
// space complexity is :- O(1) for not using a temporary array


public class QUICK_SORT {
    static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int left = low;
        int right = high;

        while (left < right){
            // we are looking for the element which is grater than the pivot
            while (arr[left] <= pivot && left < high){
                left++;
            }
            //we are looking for the element which is lesser than the pivot
            while (arr[right] > pivot && right>low){
                right--;
            }
            if (left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // then swap the pivot and right element
        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;
        return right;
    }
    static void quicksort(int[] arr,int low ,int high){
        if (low<high){
            int par = partition(arr,low,high);
            quicksort(arr,par+1,high);
            quicksort(arr,low,par-1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {9, 4, 10, 6, 3, 50, 5};
        int low =0; int high = arr.length-1;
        quicksort(arr,low,high);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }
}
