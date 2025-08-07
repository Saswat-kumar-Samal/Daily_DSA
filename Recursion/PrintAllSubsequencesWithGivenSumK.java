package Daily_DSA.Recursion;


///  this is one technique of recursion by using pick and no pick


import java.util.ArrayList;
public class PrintAllSubsequencesWithGivenSumK {
    static void checkSubsequences(int[] arr, int target){
        ArrayList<Integer> res = new ArrayList<>();
        helperFunc(arr, 0, 0, target, res);
    }
    static void helperFunc(int[] arr, int idx, int sum, int target, ArrayList<Integer> res){
        if(arr.length == idx){
            if (sum == target){
                System.out.println(res);
            }
            return;
        }
        res.add(arr[idx]);
        sum += arr[idx];
        helperFunc(arr, idx+1, sum, target, res);
        res.removeLast();
        sum -= arr[idx];
        helperFunc(arr, idx+1, sum, target, res);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,3};
        int sum = 3;
       checkSubsequences(arr, sum);
    }
}
