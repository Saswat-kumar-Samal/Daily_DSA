package Daily_DSA.Important_SortingAlgo;

// one of the basic soring algo
// taking time --> O(n) for worst and avg. case but for best it will be O(n) for sorted array
// space --> O(1)


public class BUBBLE_SORT {
    static void BubbleSort(int[] arr){
        int temp=0;
        int n = arr.length;
        for(int i = n-1;i >= 1;i--){
            boolean didSwap=false;
            for(int j=0;j <= i-1;j++){
                if (arr[j] > arr[j+1]){
                    temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap=true;
                }
            }
            if (!didSwap){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        BubbleSort(arr);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }
}
