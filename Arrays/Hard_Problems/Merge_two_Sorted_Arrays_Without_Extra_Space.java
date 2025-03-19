package Daily_DSA.Arrays.Hard_Problems;

/// Question -- you have to merge the sorted array without using the extra space

import java.util.*;
public class Merge_two_Sorted_Arrays_Without_Extra_Space {
    ///  this is the brute approach
    /// time --> O(n+m) + O(n+m)
    /// space --> O(n+m)
    static void merge(int[] arr1, int m, int[] arr2, int n){
        // we need a third array
        int[] arr3 = new int[n+m];
        int i=0; int j=0;
        int k=0;
        while (i<m && j<n){
            if(arr1[i] <= arr2[j]){
                arr3[k++] = arr1[i];
                i++;
            }else{
                arr3[k++] = arr2[j];
                j++;
            }
        }
        // if first array exhausted then
        while (j<n){
            arr3[k++] = arr2[j];
            j++;
        }
        // if second array exhausted
        while (i<m){
            arr3[k++] = arr1[i];
            i++;
        }


        for(int idx=0; idx< n+m; idx++){
            if (idx < n){
                arr1[idx] = arr3[idx];
            }else{
                arr2[idx - n] = arr3[idx];
            }
        }
    }



    ///  this is the OptimalSolution
    /// time --> O( min (n,m) ) + O(n log n) + O(m log m)
    /// space --> O(1)
    static void OptimalSolution1(int[] a, int n, int[] b, int m){
        int left =n-1;
        int right=0;
        while (left >= 0 && right < m){  // time --> O( min (n,m) ) we know one of condition will go false who ever is minimum
            if (a[left] > b[right]){
                int temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--; right++;
            }else{
                break;
            }
        }
        Arrays.sort(a); // time -- O(n * log n )
        Arrays.sort(b); // time -- O(m * log m)
        System.out.println("elements in a:- ");
        for (int ele:a){
            System.out.print(ele+" ");
        }
        System.out.println();
        System.out.println("elements in b:- ");
        for (int ele:b){
            System.out.print(ele+" ");
        }
    }



    ///  this is the Optimal solution 2
    /// time --> O(log (n+m) ) *  O(n+m)
    /// space --> O(1)
    static void SwapIfGrater(int[] a,int[] b ,int idx1 , int idx2){
        if(a[idx1] > b[idx2]){
            int temp = a[idx1];
            a[idx1] = b[idx2];
            b[idx2] = temp;
        }
    }
    static void OptimalSolution2(int[] a, int n , int[] b , int m) {
        int len = (n + m);
        int gap = (len/2) + (len%2);
        while (gap > 0){
            int left = 0;
            int right = left + gap;
            while (right < len){
                if (left < n && right >= n){  // this condition means I am in the left array and comparing with arr1 and arr2
                    SwapIfGrater(a,b,left , right - n);
                }else if (left >= n){  // this condition means I am in the right array and comparing with the arr2 and  arr2
                    SwapIfGrater(b,b,left - n, right - n);
                }else{  // otherwise I am in the left array (left < n and right < n) , and comparing with arr1 with arr1
                    SwapIfGrater(a,a,left , right);
                }
                left++;right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }
    public static void main(String[] args) {
        int[] a = {1,3,5,7};
        int[] b = {0,2,6,8,9};
        OptimalSolution2(a,a.length, b,b.length);
    }
}
