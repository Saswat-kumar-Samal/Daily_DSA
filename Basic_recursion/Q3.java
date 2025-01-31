package Daily_DSA.Basic_recursion;

// Q -  print in terms of n to 1

// this is in terms of back tracking means when the function is returning and
// doing some operation at returning then it is called 'BACKTRACKING'

// time complexity is :- O(n)
// space complexity is : - O(n) stack space

import java.util.*;
public class Q3 {
    static void printNum(int i ,int n){
        if (i>n){
            return;
        }
        printNum(i+1,n);
        System.out.println(i);
    }


    static void printnum2(int i,int n){
        if (i==0){
            return;
        }
        printnum2(i-1,n);
        System.out.println(i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number :- ");
        int n = sc.nextInt();
        printnum2(4,n);
    }
}
