package Daily_DSA.Bit_manipulation.AdvanceMath;

import java.util.ArrayList;
import java.util.*;

public class PrintAllDivisor {
    static void printDivisors(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                ans.add(i);
                if(n/i != i) ans.add(n/i);
            }
        }
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        int num = 36;
        printDivisors(num);
    }
}
