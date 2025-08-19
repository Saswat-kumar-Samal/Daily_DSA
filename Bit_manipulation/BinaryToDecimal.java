package Daily_DSA.Bit_manipulation;

public class BinaryToDecimal {
    static int Function(String str){
        int ans  = 0;
        int p2 = 1;
        for(int i = str.length()-1; i>=0 ;i--){
            if (str.charAt(i) == '1') ans += p2;
            p2 *= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Function("1111"));
    }
}
