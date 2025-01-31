package Daily_DSA.Basic_recursion;


// Q - print 1 to N linearly using recursion

// time complexity is :- O(n)
// space complexity is : - stack space :- O(n)

import java.util.*;
public class Q2 {
    static void PrintNum(int i,int n){
        if (i>n){
            return;
        }
        System.out.println(i);
        PrintNum(i+1,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number :- ");
        int n = sc.nextInt();
        PrintNum(1,n);
    }
}
