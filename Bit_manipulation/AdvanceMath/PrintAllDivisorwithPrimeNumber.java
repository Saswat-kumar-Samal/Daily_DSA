package Daily_DSA.Bit_manipulation.AdvanceMath;

import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisorwithPrimeNumber {
    static List<Integer> primeDivisor(int num){
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                list.add(i);
                while (num % i == 0) num /= i;
            }
        }
        if(num != 1) list.add(num);
        return list;
    }
    public static void main(String[] args) {
        int num = 100;
        System.out.println(primeDivisor(num));
    }
}
