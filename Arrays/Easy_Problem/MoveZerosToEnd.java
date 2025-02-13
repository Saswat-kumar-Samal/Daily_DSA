package Daily_DSA.Arrays.Easy_Problem;

///  Question --> move zeros to the end

import java.util.*;
public class MoveZerosToEnd {

    /// total time complexity is ---> O(2n)
    /// space complexity is ----> O(n) at the worst time there is no zeros in the array
    static void BruteApproach(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int Zeros=0;
        for (int ele : arr){ //-----------------> O(n)
            if (ele!=0) list.add(ele);
            else Zeros++;
        }

        int i=0;
        for(int ele:list){ //----------------------> O(n-x)
          arr[i++] = ele;
        }

        for(int j=0; j < Zeros ;j++){ //---------------------> O(x)
            arr[i++] = 0;
        }
        ///  printing the array
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }




    ///  this optimal approach
    /// TC-------->
    ///  SC------->
    static void OptimalApproach(int[] arr){
        /// first find the index where the first zero is occurring
        int n =arr.length;
        int j=-1;
        for(int i=0;i <= n-1; i++){  //------------> O(x) let first zero occurs at the x index so it will run for x times
            if (arr[i] == 0) {
                j=i;
                break;
            }
        }

        if (j != -1){  ///  if j == -1 that means there is no zeros in the array so we write the condition
            for(int i=j+1 ; i <= n-1; i++){  //------------> O(n-x) and you know why it is running for (n-x) times
                if (arr[i]!=0){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;  // after swapping 'j' should go to the next element for further swapping
                }
            }
        }else{
            return;
        }
    }
    public static void main(String[] args) {
        int[] arr = {12,3,6,5,85,0,6,0,0,8};
        OptimalApproach(arr);
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }
}
