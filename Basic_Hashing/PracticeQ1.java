package Daily_DSA.Basic_Hashing;

// COUNT THE FREQUENCY OF EACH ELEMENT IN THE ARRAY

//      Example:
//      Input: arr[] = {2,2,3,4,4,2};
//      Output: 2  3
//              3  1
//              4  2
//      Explanation: 2 occurs 3 times in the array
//	                 3 occurs 1 time in the array
//                   4 occurs 2 time in the array



// brute for approach
// TC --> O(n*n)
// SC --> o(n)

public class PracticeQ1 {
    static void Frequency(int[] arr,int len){
        boolean[] visited = new boolean[len];

        for (int i=0; i<len ; i++){

            // skip the element if it is visited
            if (visited[i]){
                continue;
            }

            // if not visited then count frequency
            int cnt=1;
            for (int j=i+1; j<len; j++){
                if (arr[i] == arr[j]){
                    visited[j]=true;
                    cnt++;
                }
            }
            System.out.println(arr[i]+ " "+cnt);
        }
    }
    public static void main(String[] args) {
       int arr[] = {2,2,3,4,4,2};
       int n = arr.length;
       Frequency(arr,n);
    }
}





// this is the optimal approach using the hashmap
// time complexity is :- O(n)  --> for storing the element of array in the hashmap
// space complexity is :- O(k)  --> k is the no of unique element stored in the map



import java.util.*;
public class PracticeQ1 {
    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < arr.length; i++){
            int key = arr[i];
            int frqe = 0;
            if (map.containsKey(key)){
                frqe = map.get(key);
            }
            frqe++;
            map.put(key,frqe);
        }


        // printing the hashmap
        map.forEach((k,v) -> {
            System.out.println(k+" occurs "+v+" times in the array");
        });
    }
}
