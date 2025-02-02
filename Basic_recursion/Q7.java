package Daily_DSA.Basic_recursion;

// check the given number is palindrome or not using recursion


public class Q7 {
    // we know palindrome means what
    // instead of swapping the corresponding index of string
    // we are just checking the corresponding index of the string if they are equal then return true otherwise false
    static boolean isPalindrome(String str, int i , int len){
        if (i>=len/2) return true;
        if (str.charAt(i) != str.charAt(len-i)) return false;
        return isPalindrome(str , i+1, len);
    }
    public static void main(String[] args) {
        String str = "11211";
        System.out.println(isPalindrome(str, 0 ,str.length()-1));
    }
}
