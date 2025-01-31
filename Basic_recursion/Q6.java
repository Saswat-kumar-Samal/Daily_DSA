package Daily_DSA.Basic_recursion;

// Q -  reverse an array


public class Q6 {
    // using two pointer
    // time complexity :- The recursion will make n/2 calls,
    // but since we drop constant factors in Big O notation, it simplifies to O(n).
    static int[] RevArray(int[] arr , int left ,int right){
        if (left>=right){
            return arr;
        }
        int temp = arr[left];
        arr[left]= arr[right];
        arr[right] = temp;

        return RevArray(arr,left+1,right-1);
    }


    // using one pointer
    // we are starting from i=0 index and keep on swapping with the corresponding swapping index
    static int[] revArrayOnePointer(int[] arr , int i , int n){
        if (i >= n/2){
            return arr;
        }
        int temp = arr[i];
        arr[i] = arr[n-i];
        arr[n-i] = temp;
        return revArrayOnePointer(arr, i+1, n);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4};
        // for two pointer use
//        for (int i : RevArray(arr,0, arr.length-1)){  // here this function returning the reversed array
//            System.out.print(i+" ");                           // and we are printing it simultaneously
//        }


        // for one pointer use

        for(int i : revArrayOnePointer(arr, 0 ,arr.length-1)){
            System.out.print(i+" ");
        }
    }
}
