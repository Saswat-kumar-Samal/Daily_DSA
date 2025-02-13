package Daily_DSA.Arrays.Easy_Problem;


/// find the union and intersection of two sorted array


import java.util.*;
public class Find_The_Union_Two_Sorted_Arrays {

    /// time complexity ---> O(n1 * log n) + O(n2 * log n) + O(n1 + n2)
    /// space complexity ---> O(n1 + n2)  in worst case if we have to make set containing all the unique element
    static ArrayList<Integer> Union(int[] arr1 , int[] arr2){
        ArrayList<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int ele:arr1){   //------------------> O(n1logn)
            set.add(ele);
        }
        for (int ele:arr2){  //-----------------------> O(n2logn)
            set.add(ele);
        }
        for (int ele:set){ // ------------------------> O(n1+n2) at the worst case if every element in both array will be unique
            temp.add(ele);
        }
        return temp;
    }




    ///  this is the optimal approach by using 2 pointer technique
    ///  time complexity is --> O(n1 + n2) we have to travel entire both arrays in order to add to Union array
    ///  space complexity is ---> O(n1 + n2)  we are using this for returning the answer , we are not using it in our algo
    static ArrayList<Integer> OptimalApproach(int[] arr1, int[] arr2){
        ArrayList<Integer> UnionArr = new ArrayList<>();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i=0, j =0;
        while (i < n1 && j < n2){
            if (arr1[i] <= arr2[j]){
                if (UnionArr.isEmpty() || UnionArr.getLast() != arr1[i]){
                    UnionArr.add(arr1[i]);
                }
                i++;
            }else{
                if (UnionArr.isEmpty() || UnionArr.getLast() != arr2[j]){
                    UnionArr.add(arr2[j]);
                }
                j++;
            }
        }
        ///  if first array will exhausted then we have to iterate over the second array
        while (j < n2){
            if (UnionArr.isEmpty() || UnionArr.getLast() != arr2[j]){
                UnionArr.add(arr2[j]);
            }
            j++;
        }

        ///  if second array will exhaust then we have to iterate over the first array
        while (i < n1){
            if (UnionArr.isEmpty() || UnionArr.getLast() != arr1[i]){
                UnionArr.add(arr1[i]);
            }
            i++;
        }
        return UnionArr;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,3,4,5};
        int[] arr2 = {1,2,3,3,5};
        for(int ele:Union(arr1,arr2)){
            System.out.print(ele+" --> ");
        }
    }
}
