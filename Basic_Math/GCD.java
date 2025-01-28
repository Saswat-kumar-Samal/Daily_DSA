package Daily_DSA.Basic_Math;

public class GCD {
    // the brute force method
    // time complexity is O(min(num1 , num2))

    static int gcd(int num1,int num2){
        int gcd=0;
        for(int i=Math.min(num1,num2); i>=1; i--){
            if (num1%i==0 && num2%i==0){
                gcd=i;
                break;
            }
        }
        return gcd;
    }


    // this is the better method to solve the GCD is Euclidean algorithm
    // the time complexity is O (log (min (num1 , num2)) base phi)
    static int improvedGCD(int num1 , int num2){
        while (num1>0 && num2>0){
            if(num1>num2)
                num1=num1%num2;
            else
                num2 = num2%num1;
        }
        if(num1==0)
            return num2;
        else
            return num1;
    }
    public static void main(String[] args) {
        int num1 =11;
        int num2 = 13;
        System.out.println(improvedGCD(num1,num2));
    }
}
