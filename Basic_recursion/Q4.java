package Daily_DSA.Basic_recursion;

// Q - sum of n natural numbers -> using parameterised and functional ways


import java.util.*;
public class Q4 {

    // first using parameterised way
    static void SumOfNatural(int i, int sum){
        if (i<1){
            System.out.println(sum);
            return;
        }
        SumOfNatural(i-1,sum+i);
    }

    // here we do not print the sum , instead of the that we want the function will return something
    static int Sum(int n){
        if (n==0){
            return 0;
        }
        return n + Sum(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the range for 1 to N , here enter the N :- ");
        int n = sc.nextInt();
        int sum =0;
       // SumOfNatural(n,sum); // initially sum is Zero --
        System.out.println(Sum(n));
    }
}
