package Daily_DSA.Basic_Hashing;

// CHARACTER HASHING
// similar to the integer hashing but slightly change in this code

import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "abccbaddef";
        // pre-storing
        int[] hasharr = new int[26]; // let's assume that the string contains only small letters
                                     // so we take the hasharray size is 26
        for (int i=0;i<str.length();i++){
            hasharr[str.charAt(i) - 'a'] +=1;
        }

        // fetching
        System.out.println("enter the no of Quarries :- ");
        int q = sc.nextInt();
        while (q-- !=0){
            System.out.println("enter the char that you want to fetch:-");
            char c = sc.next().charAt(0);
            System.out.println(hasharr[c-'a']);   // here we do  ( c-'a' )  bcz we need the index that
                                                  // we are looking for
        }




    }
}
