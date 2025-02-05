package Daily_DSA.Basic_Hashing;

// integer hashing using Hashmap

import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of input array");
        int n = sc.nextInt();

        //pre-computing while taking the input

        int[] arr = new int[n];
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<arr.length;i++){             ///  at the time of taking the input i am hashing the elements
            arr[i] = sc.nextInt();
            int key = arr[i];
            int fre = 0;
            if (hash.containsKey(key)){
                fre = hash.get(key);       /// here fetching the frequency and incrementing it
            }
            fre++;
            hash.put(key,fre);
        }


        // fetching

        System.out.println("enter the no of Quarries");
        int q = sc.nextInt();
        System.out.println("enter the elements for getting frequencies");
        while (q-- !=0){
            int num = sc.nextInt();
            if (hash.containsKey(num)){         ///  first check the given Query is present in the hashmap or not
                System.out.println(hash.get(num)); /// if present then print that frequency of the number
            }else {
                System.out.println(0);              /// otherwise print 0
            }
        }
    }
}
