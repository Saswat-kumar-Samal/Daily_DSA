package Daily_DSA.Arrays.Easy_Problem;

import java.util.ArrayList;

///  finding the intersection


public class Find_the_Intersection_of_2_sorted_array {


    /// brute approach
    /// time complexity is -> O(n1 * n2)
    /// space complexity is --> O(n2) because we are using the visited array of n2 length

    static ArrayList<Integer> BruteIntersection(int[] arr1,int[] arr2){
        ///  first create a visiting array to keep tracking for the element
        int n1 = arr1.length; int n2 = arr2.length;
        int[] visited = new int[n2];
        /// create an arraylist for answer
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<=n1-1; i++){
            for (int j=0; j<=n2-1; j++){
                if (arr1[i] == arr2[j] && visited[j] ==0){
                    ans.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i]) break;  /// bez if we find the number grater than we are looking for then we do not need to go further
            }
        }
        return ans;
    }




    ///  optimal solution by using 2 pointer technique
    ///  time complexity is --> O(n1 + n2) if every element of arr1 will get the partner of them means they equal
    ///  space complexity is --> O(1)
    static ArrayList<Integer> OptimalIntersection(int[] arr1,int[] arr2){
        ArrayList<Integer> ans = new ArrayList<>();
        int n1 = arr1.length; int n2 = arr2.length;
        int i=0,j=0;
        while (i < n1 && j < n2){
            if (arr1[i] < arr2[j]){  ///  if 'i' th index is less than 'j' th index please move i forward
                i++;
            }else if (arr2[j] < arr1[i]){ ///  if 'j' th index is less than 'i' th index please move j forward
                j++;
            }else {
                ans.add(arr1[i]);    /// if you are matched then you both of you should move forward;
                i++;j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,3,4,5,6,9};
        int[] arr2 = {2,3,3,5,6,6,7,9};
        System.out.println(OptimalIntersection(arr1,arr2));
    }
}
