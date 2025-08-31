package Daily_DSA.Bit_manipulation.AdvanceMath;

public class Sieve_of_Eratosthenes {
    ///  this is the algorithm related to prime number
    /// means you have given a number you have to tell how many prime numbers are there inside the number

    static int NoOfPrimes(int n){
        if(n <= 0) System.out.println("the number is invalid !");
        if(n == 2) return 0;
        if(n == 3) return 1;
        int[] primes = new int[n+1];
        for(int i = 2; i < primes.length; i++) primes[i] = 1;
        for(int i = 2; i*i <= n; i++){
            if(primes[i] == 1){
                for(int j = i*i; j <= n; j += i) primes[j] = 0;
            }
        }
        int prime = 0;
        for(int i = 2; i < n; i++){
            if(primes[i] == 1) prime++;
        }
        return prime;
    }
    public static void main(String[] args) {
        int num = 20;
    }
}
