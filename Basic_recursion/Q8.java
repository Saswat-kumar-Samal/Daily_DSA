package Daily_DSA.Basic_recursion;

// fibbonacci number
// write a function which will return f(n) --> nth fibbonacci number
// series --> 0 1 1 2 3 5 8 13 21
// ex -> f(4) it will give the 3

public class Q8 {
    // time complexity is -> nearly equals 2^n not exactly 2^n , but exponential in nature

    static int fibbo(int n){
        if (n<=1){
            return n;
        }
        int last = fibbo(n-1);
        int slast = fibbo(n-2);
        return last + slast;
    }
    public static void main(String[] args) {
        System.out.println(fibbo(4));
    }
}
