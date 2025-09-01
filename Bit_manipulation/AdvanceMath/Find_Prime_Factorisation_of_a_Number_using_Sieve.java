package Daily_DSA.Bit_manipulation.AdvanceMath;



import java.util.*;
public class Find_Prime_Factorisation_of_a_Number_using_Sieve {
    static int n =2*(int)Math.pow(10, 5) + 1;
    static int[] primes = new int[n];
    static boolean sieveBuilt = false;
    static void buildSieve() {
        if (sieveBuilt) return;  // ✅ build only once
        for (int i = 2; i < n; i++) primes[i] = i;
        for (int i = 2; i * i < n; i++) {
            if (primes[i] == i) {
                for (int j = i * i; j < n; j += i) {
                    if (primes[j] == j) {
                        primes[j] = i;
                    }
                }
            }
        }
        sieveBuilt = true;
    }
    static List<Integer> findPrimeFactors(int N) {
        buildSieve();
        List<Integer> list = new ArrayList<>();
        while(N != 1){
            list.add(primes[N]);
            N /= primes[N];
        }
        return list;
    }
    public static void main(String[] args) {

    }
}
