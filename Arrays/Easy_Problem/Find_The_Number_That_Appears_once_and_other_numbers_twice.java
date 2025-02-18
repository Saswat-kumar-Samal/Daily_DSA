package Daily_DSA.Arrays.Easy_Problem;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

///  Question --> Find the number that appears once, and other numbers are twice.


public class Find_The_Number_That_Appears_once_and_other_numbers_twice {
    static int BruteApproach(int[] arr){
        ///  this is the brute approach
        ///  time --> O(n^2)
        /// space --> O(1)
        int n = arr.length;
        for (int i=0; i<=n-1 ;i++){
            int num = arr[i];
            int cnt=0;
            for (int j=0 ; j<=n-1;j++){
                if (arr[j] == num) cnt++;
            }
            if (cnt==1) return arr[i];
        }
        return -1;
    }



    ///  this is the better approach by using hash array
    /// time -->  O(3n)
    /// space -->  O( maximum element present in the input array )
    static int BetterApproach_1(int[] arr){
        int n =arr.length;
        ///  first find the maximum element in the array so that we can define the hash array size
        int maxi=0;
        for (int i=0;i <=n-1 ;i++){               //------------> O(n)
            if (arr[i] > maxi) maxi = arr[i];
        }
        ///  then define the hash array
        int[] Hash = new int[maxi+1];

        ///  then iterate over the array to store the frequency of the element of the array
        for (int i=0 ;i <= n-1 ; i++){   //------------> O(n)
            Hash[arr[i]]++;
        }

        ///  then iterate over the hash array to find the number
        for (int i=0; i<= Hash.length ; i++){  //------------> O(n)
            if (Hash[i] == 1) return i;
        }

        return -1;
    }




    ///  but every time we can not use the hash array for hashing bcz if the number will be very big then we can not store it in the hash array
    /// that's why we are using the MAP
    /// time -->  O(n * log n)  + O( n/2 + 1 )
    /// space -->  O( n/2 + 1 )  for using the map
    static int Better_2(int[] arr){
        Map<Integer, Integer> mpp = new HashMap<>();
        int n =arr.length;
        for (int i=0; i<= n-1; i++){  ///  putting all the element in the hashmap
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);   /// time taken into put the element in the hash map is O(n * log n)
        }


        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {    ///  time for iterating over the map is O( n/2 + 1 )
            if (entry.getValue() == 1) {
                return entry.getKey();  // ✅ Now returning correctly
            }
        }

        return -1;
    }





    /// this is the optimal solution by using XOR operation
    /// time --> O(n)
    /// space --> O(1)
    static int OptimalApproach(int[] arr){
        int n = arr.length;
        int num = 0;
        for (int i=0 ; i<=n-1; i++){
            num ^= arr[i];
        }
        return num;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4};
        System.out.println(BruteApproach(arr));
    }
}
