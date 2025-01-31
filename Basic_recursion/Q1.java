package Daily_DSA.Basic_recursion;

// Q - printing the n names using recursion
// time complexity is :- O(n)
// space complexity is : - stack space :- O(n)

import java.util.*;
public class Q1 {
    static void PrintName(int i , int n){
        if (i>n){
            return;
        }
        System.out.println("chiku");
        PrintName(i+1,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the range:- ");
        int n = sc.nextInt();
        PrintName(1,n);
    }
}
