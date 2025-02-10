package Daily_DSA.Important_SortingAlgo;


// insertion sort algo is --> (always takes an element and placed it in correct place)
// TC --> O(n^2) for worst case and Avg. case but for best case O(n) when a sorted array is given as input to sort
// SC --> O(1) not using any extra array or something

public class INSERTION_SORT {
    static void InsertionSort(int[] arr){
        int n =arr.length;
        int tempo =0;
        for (int i=0;i <= n-1;i++){
            int j =i;
            while (j>0 && arr[j-1] > arr[j]){
                // swap the (j-1) index and (j) index
                tempo = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = tempo;
                // after swapping just go left
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        InsertionSort(arr);
        System.out.println("after the Insertion sort:-");
        for (int i : arr){
            System.out.print(i+" ");
        }
    }
}
