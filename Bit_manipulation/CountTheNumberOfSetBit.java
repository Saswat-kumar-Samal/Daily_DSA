package Daily_DSA.Bit_manipulation;

public class CountTheNumberOfSetBit {
    static int Count(int num){
        int cnt = 0;
        while (num != 0){
            num = num & num-1;
            cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(Count(13));
    }
}
