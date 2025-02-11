package Daily_DSA.Arrays.Easy_Problem;









import java.util.*;
public class SecondLargestEleInArray {

    ///  Tc -> O(nlogn)
    ///  sc ->  O(1)
    static int BruteApproachSecondLargest(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int secondlarge =0;
        int large = arr[n-1];
        for(int i =n-2;i>=0;i--){  /// we start from the n-2 index bcz we know that the large element is at n-1 index
            if (arr[i] != large){
                secondlarge = arr[i];
                break;
            }
        }
        return secondlarge;
    }



    ///  TC -> O(2n)
    /// sc -> O(1)
    static int BetterApproachSecondLargest(int[] arr){
        ///  first calculate the largest element
        int n = arr.length;
        int large=0;
        for(int i=0;i<=n-1;i++){
            if (large < arr[i])
                large=arr[i];
        }
        ///  then find the second largest
        int secondlargest=-1;
        for (int i=0;i<=n-1;i++){
            if (arr[i] > secondlargest && arr[i] != large)
                secondlargest = arr[i];
        }
        return secondlargest;
    }


    ///  TC -> o(n)
    /// SC -> O(1)
    static int OptimalApproachSecondLargest(int[] arr){
        int n =arr.length;
        int largest = arr[0]; int secondlargest = Integer.MIN_VALUE;
        for (int i=0;i<=n-1;i++){
            if (arr[i] > largest){
                secondlargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondlargest) {
                secondlargest = arr[i];
            }
        }
        return secondlargest;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,3,7,7,5};
        System.out.println(OptimalApproachSecondLargest(arr));
    }
}
