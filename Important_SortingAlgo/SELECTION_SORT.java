package Daily_DSA.Important_SortingAlgo;



// the algo is select the minimum and swap
// TC --> O(n)
// space --> O(1)


public class SELECTION_SORT {
    static void SelectionSort(int[] arr){
        int n = arr.length;
        int tempVar = 0;
        int mini=0;
        for (int i=0;i<= n-2;i++){
            mini=i;
            for(int j=i;j<=n-1;j++){
                if (arr[j] < arr[mini]) mini =j;
            }
            // swap that number with minimum element
            tempVar = arr[i];
            arr[i] = arr[mini];
            arr[mini] = tempVar;
        }
    }
    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 100};
        System.out.println("after the selection sort");
        SelectionSort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
