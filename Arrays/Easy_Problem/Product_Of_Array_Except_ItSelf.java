package Daily_DSA.Arrays.Easy_Problem;

import java.util.Arrays;

public class Product_Of_Array_Except_ItSelf {



    ///  this is brute approach
    /// time complexity is :- O(n^2)
    /// space complexity is :- O(1)  , using a extra array of O(n) just to return the answer only
    static int[] BruteApproach(int[] arr){
        int n = arr.length;

        int[] res = new int[n];  /// we are actually not using this arrays for out algorithm ,, we are using this array just to return the ans only , so space complexity is O(1)
        Arrays.fill(res,1);  // we have to make all the array value as 1 , otherwise all the value of array will be the 0 , so for the product operation their will be no obstacle

        for (int i=0;i <= n-1;i++){
            for (int j=0; j <= n-1; j++){
                if (i!=j){
                    res[i] *= arr[j];
                }
            }
        }
        return res;
    }





    ///  this is the optimal solution
    /// time complexity is :- O(n)
    /// space is :- O(1)
    static int[] OptimalApproach(int[] arr){
        int n = arr.length;
        ///  for the optimal approach we need to follow the spacial case only , the special case is having 0 in the array element
        int[] res = new int[n];
        int Zeros =0,idx=0 , prod=1;

        for (int i=0; i<=n-1; i++){
            if (arr[i] == 0){         ///  we are counting the zeros present int the array and , at what position o is occurring
                Zeros++; idx=i;
            }else prod *= arr[i];   /// otherwise calculate the product
        }

        if (Zeros ==0){      ///  if there is no Zeros in the array that means the product is whole product divided by the corresponding index element only
            for (int i=0; i<=n-1 ;i++){
                res[i] = prod/arr[i];
            }
        }else if (Zeros==1){   ///  if there is one zeros that means , the product will exist for the first occurring Zero only , which we have  calculated before
            res[idx] = prod;
        }
                               /// if there is more than one zeros in the array then the all value in the answer array will be 0
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {10,5,6,9,8};
        for (int ele : OptimalApproach(arr)){
            System.out.print(ele+" ");
        }
    }
}
