package Daily_DSA.Bit_manipulation;

public class SwapTwoNumbers {
    static void Swap(int num1, int num2){
        System.out.println("before swapping the number num1 : "+num1+", num2 : "+num2);
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("before swapping the number num1 : "+num1+", num2 : "+num2);
    }
    public static void main(String[] args) {
        Swap(5, 10);
    }
}
