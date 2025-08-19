package Daily_DSA.Bit_manipulation;

public class DecimalToBinary {
    // function will convert decimal to binary
    static String Func(int num){
        StringBuilder res = new StringBuilder();
        while (num > 0){
            if (num % 2 == 1) res.append("1");
            else res.append("0");
            num /= 2;
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(Func(10));
    }
}
