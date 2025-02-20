package Daily_DSA.Arrays.Medium_Problem;


import java.util.*;

///  Question - > Sort an array of 0s, 1s and 2s


public class Sort_an_Array_of_0s_1s_and_2s {


    static void BruteApproach(int[] arr){
        ///  for the brute approach you can simply sort it
        /// time --> O(n * log n)  --> for using QuickSort
        /// space --> O(1)  ---> for using QuickSort
        Arrays.sort(arr);
    }






    ///  this is a better approach
    /// time --> O(2n)
    /// space --> O(1)
    static void BetterApproach(int[] arr){
        int n = arr.length;
         int Zeros=0,ones=0,twos=0;
         for (int i=0; i<=n-1; i++){    // time for this 'for' loop is :- O(n)
             if (arr[i] == 0) Zeros++;
             else if (arr[i] == 1) ones++;
             else twos++;
         }
         int i=0;
         while (Zeros--!=0) arr[i++] = 0;
         while (ones--!=0) arr[i++] = 1;     // this three for loop time complexity is :- O(n) because at last the all the frequency of element is the total length of element
         while (twos--!=0) arr[i++] = 2;
    }






    ///  this is optimal solution by using the "Dutch national flag algorithm" carefully understand it
    /// time -->  O(n)
    /// space --> O(1)
    static void optimalApproach(int[] arr){
        ///  it is a Mind blowing concept , you just carefully understand it
        int n = arr.length;
        int low =0;  int mid =0; int high=n-1;

        while (mid <= high){
            if (arr[mid] == 0){ // if Mid-element is 0 then (swap arr[mid] and arr[low] and move 'low' and 'mid' pointer)
                 int temp = arr[low];
                 arr[low] =arr[mid];
                 arr[mid] = temp;
                 low++; mid++;
            }else if (arr[mid] == 1) {  // if Mid-element is 1 then (just move the 'mid' pointer , no need of swapping then are in the correct section)
                mid++;
            }else{
                int temp=arr[high];
                arr[high] =arr[mid];     // if Mid-element is 2 then (swap arr[mid] and arr[low] and move 'low' and 'mid' pointer)
                arr[mid] = temp;
                high--;
            }
        }
    }




    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        optimalApproach(arr);
        for (int ele : arr){
            System.out.print(ele+ " ");
        }
    }
}
