package Daily_DSA.Bit_manipulation;

public class CheckingTheNUmberIsPowerOfTwoOrNot {

    ///  we do so because every power of two has 1 set bit
    static boolean Check(int n){
        return ((n & n-1) == 0);
    }
    public static void main(String[] args) {
        System.out.println(Check(32));
    }
}
