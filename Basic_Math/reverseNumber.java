package Daily_DSA.Basic_Math;

public class reverseNumber {
    // reverse the number
    // we have to do with the extraction of number
    static int reverseNum(int num){
        int rev =0;
        int rem=0;
        while (num>0){
            rem = num%10;
            rev = (rev*10)+rem;
            num/=10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int num = 1528;
        System.out.println(reverseNum(num));
    }
}
