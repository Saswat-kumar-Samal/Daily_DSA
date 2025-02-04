package Daily_DSA.Basic_Hashing;

// we are learning the basic hashing
// counting the frequencies of the given quarries
// here hashing meaning --> pre-storing and fetching


import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of given array");
        int n = sc.nextInt();

        int[] arr = new int[n]; // initialize given array
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        //pre-computation

        int[] hashArr = new int[13]; // we know that the maximum array size can go till 13 so we directly use here
                                     // otherwise you need to find the maximum element in the array

        for(int i=0;i<arr.length;i++){
            hashArr[arr[i]] +=1;
        }


        // here we are fetching now
        System.out.println("enter the no of quarries for fetching :- ");
        int q = sc.nextInt();
        while (q-- !=0){
            int num = sc.nextInt();
            // fetching
            System.out.println(hashArr[num]+" --> ");
        }
    }
}
