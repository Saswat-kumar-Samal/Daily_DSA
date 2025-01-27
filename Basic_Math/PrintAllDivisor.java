package Daily_DSA.Basic_Math;
import  java.util.*;
public class PrintAllDivisor {
    // print all the divisors
    static void PrintDivisors(int num){
        for (int i=1; i<= num ; i++){
            if (num%i==0){
                System.out.print(i+" , ");
            }
        }
    }

    // the above algo's time complexty is O(n)
    // we can do with some better time complexity , so we have to some math matical observation

    static List<Integer> improvedDivisors(int num){
        List<Integer> l = new ArrayList<Integer>();
        // it will take O(sqrt(n)) time
        for (int i=1 ; (i*i<num) ; i++){
            if(num%i == 0){
                l.add(i);
                if (num/i!=i){
                    l.add(num/i);
                }
            }
        }
        // it is sorting the number of divisors list
        // so the time taken is -->  O (no of divisors * log(no of divisors))
        Collections.sort(l);
        return l;
    }
    public static void main(String[] args) {
        int num = 36;
        System.out.println(improvedDivisors(num));
    }
}
