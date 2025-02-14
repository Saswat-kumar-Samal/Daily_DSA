package Daily_DSA.Arrays.Easy_Problem;

///  Question --> maximum consecutive ones

public class Maximum_Consecutive_Ones {

    /// I think we should not go for brute we directly solve by optimal sol
    /// time --> O(n)
    ///  space --> O(1)
    static int OptimalAns(int[] arr){
        int n =arr.length;
        int maxi=0;
        int cnt =0;
        for (int i=0; i<=n-1; i++){
            if (arr[i] == 1){
                cnt++;
                maxi = Math.max(maxi,cnt);
            }else{
                cnt=0;
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,0,1,1,1,1};
        System.out.println(OptimalAns(arr));
    }
}
