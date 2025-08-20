package Daily_DSA.Bit_manipulation;


///  these are extremely fast solution

public class CheckTheithBItIsSetOrNot {
    ///  using the left shift operator
    static boolean check(int num, int i){
        return (num & (1 << i)) != 0;
    }

    ///  using the right shift operator
    static boolean checkRightShift(int num, int i){
        return ((num >> i) & 1) == 1;
    }


    ///  setting the ith bit
    static int SetBit(int num, int i){
        return (num | (1 << i));
    }

    /// clear the ith bit
    static int ClearBit(int num, int i){
        return (num & (~(1 << 2)));
    }
    public static void main(String[] args) {
        System.out.println(ClearBit(13, 2));
    }
}
