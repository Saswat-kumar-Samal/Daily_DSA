package Daily_DSA.Arrays.Easy_Problem;

///  Question -> left rotate the array by d places

import java.util.*;
public class LeftRotateTheArray_By_d_Places {

    ///  this is a brute approach
    ///  TC -> O(d) + O(n-d) + O(d) = O(n+d)
    ///  SC -> O(d) for using the temp array
    static void D_rotationBrute(int[] arr,int n, int d){
        d = d%n;
        ArrayList<Integer> temp = new ArrayList<>();
        ///  storing the first d elements
        for (int i=0;i<d;i++){
            temp.add(arr[i]);
        }
        /// shifting (n-d) elements to d places
        for(int i=d; i<= n-1;i++){
            arr[i-d] = arr[i];
        }
        /// then push back the temp element to the last of the array
        for (int i=(n-d);i <= n-1;i++){
            arr[i] = temp.get(i-(n-d));
        }
        /// now printing the resulted array
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }




    ///  this optimal approach
    ///  TC -> O(d) + O(n-d) + O(n) = O(2n)
    /// SC  --> O(1)
    // it can be optimized by reversing algorithm
    static void reverse(int[] arr,int start , int end){
        int temp=0;
        while (start <= end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] =temp;
            start++;end--;
        }
    }
    static void D_rotationOptimal(int[] arr,int n ,int d){
        d = d%n;

        ///  reverse the array from 0 to d th element
        reverse(arr , 0 ,d-1); //----------------> O(d)

        /// reverse the array from d to n-1 th element
        reverse(arr, d,n-1);  //---------------------> O(n-d)

        ///  now reverse the total array
        reverse(arr, 0 , n-1); //-----------------> O(n)

        ///  printing the whole array
        for(int ele:arr){
            System.out.print(ele+" ");
        }

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n =arr.length;
        int d =4;
        D_rotationOptimal(arr,n,d);
    }
}
