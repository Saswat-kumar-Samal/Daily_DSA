package Daily_DSA.Arrays.Easy_Problem;


/// find the union and intersection of two sorted array


import java.util.*;
public class Find_The_Union_And_Intersection_Of_Two_Sorted_Arrays {

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
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,3,3,4,5};
        int[] arr2 = {1,2,3,3,5,6};
        for(int ele:Union(arr1,arr2)){
            System.out.print(ele+" --> ");
        }
    }
}
