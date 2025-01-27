package Daily_DSA.Basic_Math;

public class CheckPalindrome {
    // check palindrome number or not
    static boolean palindrome(int n){
        int temp = n;
        int rev = 0;
        int rem = 0;
        while (n>0){
            rem = n%10;
            rev = (rev*10)+rem;
            n/=10;
        }
        return rev==temp;
    }
    public static void main(String[] args) {
        int num = 1548;
        System.out.println(palindrome(num));
    }
}
