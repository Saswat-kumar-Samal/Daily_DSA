package Daily_DSA.Basic_Math;

public class primeNumberCheck {
    // extreme brute force approach
    // time complexity is O(n)
    static boolean isPrime(int num){
        int cnt=0;
        for(int i=1;i<= num ;i++){
            if (num%i==0){
                cnt++;
            }
        }
        return cnt==2;
    }

    // we know how to calculate the factor in O(sqrt(n)) in Divisor case
    // the time complexity is O(sqrt(n))
    static boolean isprime(int num){
        int cnt=0;
        for(int i=1;i*i<num;i++){
            if(num%i==0){
                cnt++;
                if (num/i!=i){
                    cnt++;
                }
            }
        }
        return cnt==2;
    }
    public static void main(String[] args) {
        int num =21;
        System.out.println(isprime(num));
    }
}
