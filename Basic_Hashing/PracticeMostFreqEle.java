package Daily_DSA.Basic_Hashing;


// finding the most frequent element in the array


// first bruteforce approach using visited array
// time complexity is :- O(n*n)
// space complexity is :- O(n) for using a visited array

import java.util.*;
public class PracticeMostFreqEle {
    static void countfre(int[] arr,int n){
        boolean[] visited = new boolean[n];
        int minfre =n,maxfre=0;             // here we have to take 'minfreq' as large number for easy comparing
        int minele=0,maxele=0;
        for (int i = 0; i < n; i++) {
            // if visited then skip
            if(visited[i]==true){
                continue;
            }
            // if not then count frequency
            int cnt=1;
            for (int j = i+1; j < n; j++) {
                if (arr[j]==arr[i]){
                    visited[j] = true;
                    cnt++;
                }
            }
            if (cnt>maxfre){
                maxfre=cnt;
                maxele=arr[i];
            }
            if (cnt < minfre){
                minfre = cnt;
                minele = arr[i];
            }
        }

        System.out.println("the highest frequency element is "+maxele);
        System.out.println("the highest frequency element is "+minele);
    }
    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};
        int n = arr.length;
        countfre(arr,n);
    }
}



// optimal approach for most frequent element in the array using map
// time complexity --> O(n)
// space complexity is --> O(k) for using hash map

class optimalMostFre{
    public static void main(String[] args) {
        int[] arr = {2,1,7,8,2,1,9,10,9,9,2,8,2,9,9,9,9,9};
        int ans = mostFrequentElement(arr);
        System.out.println("the most frequent element in the array is :- "+ans);
    }
    static int mostFrequentElement(int[] arr){
        Map<Integer,Integer> freMap = new HashMap<>();
        int maxfre = -1;
        int maxEle = -1;
        for(int i=0;i<arr.length;i++){

            ///  instead of writing the below if-else block i can write this code
            ///  the below one line code means --> put the freq of element , what ever it's old frequency by incrementing one and if does not exist that element
            ///  put a default element 0 for this
            freMap.put(arr[i], freMap.getOrDefault(arr[i],0)+1);


            //if (freMap.containsKey(arr[i])){
            //    int val = freMap.get(arr[i]);
            //    val+=1;
            //    freMap.put(arr[i],val);
            //}else{
            //    freMap.put(arr[i],1);
            //}

            /// while putting the element in the map i am checking for the most frequent element
            if (freMap.get(arr[i])>maxfre){
                maxfre = freMap.get(arr[i]);
                maxEle = arr[i];
            }
        }
        return maxEle;
    }
}
