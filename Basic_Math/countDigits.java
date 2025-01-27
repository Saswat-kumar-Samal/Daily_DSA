package Daily_DSA.Basic_Math;

public class countDigits {

    // playing with the Digits
    static int count_Digits(int num){
        int count = (int)(Math.log10(num)+1);       // time complexity - O (log10(n))
        return count;
    }

    public static void main(String[] args) {
        int num = 36;
    }
}
