package Daily_DSA.Basic_Math;

public class CheckArmstrong {
    // checking the number is Armstrong number or not
    static boolean ArmstrongNUM(int num){
        int temp = num;
        int temp1 = num;
        // first find out the length of the number
        int len =0;
        while (num>0){
            len++;
            num/=10;
        }

        // find out the sum each digit raised to the power it's length of the number
        int sum=0;
        int rem =0;
        while(temp>0){
            rem = temp%10;
            sum += (int)(Math.pow(rem,len));
            temp /= 10;
        }
        return temp1 == sum;
    }


    public static void main(String[] args) {
        int num = 1634;
        System.out.println(ArmstrongNUM(num));
    }
}
