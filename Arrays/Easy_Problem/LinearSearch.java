package Daily_DSA.Arrays.Easy_Problem;

///  Question --> Linear search

import java.util.*;
public class LinearSearch {

    /// time complexity is :- O(n)
    /// space complexity is :- O(1)
    static int Search(int[] arr,int target){
        int n=arr.length;
        for (int i=0;i <= n-1; i++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr ={5,8,6,10,2,84,11,2,6};
        System.out.println("enter the number you want to find:- ");
        int target = sc.nextInt();
        System.out.println(Search(arr,target));
    }
}
