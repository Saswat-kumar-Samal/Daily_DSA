package Daily_DSA.Basic_recursion;

// Q -  finding the factorial of the number n

// time complexity is :- O(n)
// space complexity is :- O(n) stack space

import java.util.*;
public class Q5 {

    // we will use the function to be return the value
    static int fact(int n){
        if (n==0){
            return 1;
        }
        return n * fact(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number :- ");
        int n = sc.nextInt();
        System.out.println("the factorial of the "+n+" is :- "+fact(n));
    }
}
