package Daily_DSA.Arrays.Easy_Problem;

/// Question --> finding the missing number in the array


public class Find_Missing_Number_In_Array {




    /// this is a brute approach
    /// time complexity is -> O(n^2)
    /// space complexity is --> O(1)

    static int BruteMissingNum(int[] arr, int N){
        for (int i=1; i<=N; i++){
            int flag=0;
            for (int j=0; j<N-1; j++){
                if (arr[j] == i){
                    /// 'i' is present in the array
                    flag=1;
                    break;
                }
            }
            if (flag==0) return i;
        }
        return -1;
    }




    /// this is little bit better approach by using Hashing
    ///  time complexity --> O(n) + O(n) = O(2n)
    ///  space --> O(n)  for using hash array
    static int BetterApproach(int[] arr,int N){
        int[] hashArr = new int[N+1];
        for (int i=0; i < N-1; i++){
            hashArr[arr[i]] =1;
        }
        ///  then find who is missing
        for (int i =1; i<hashArr.length; i++){
            if (hashArr[i] ==0 ) return i;
        }
        return -1;
    }




    ///  optimal solution - 1 by using the sum
    /// time --> O(n)
    /// space --> O(1)
    static int Optimal_1MissingNum(int[] arr,int N){
        /// first sum of first natural number
        int sum = (N*(N+1))/2;
        ///  then sum of all the number of the array
        int s2=0;
        for(int i=0;i<N-1;i++){
            s2+=arr[i];
        }
        return sum-s2;
    }





    /// optimal solution -2 by using XOR
    /// time --> O(n)
    /// space --> O(1)
    static int Optimal_2MissingNum(int[] arr, int N){
        int Xor1 = 0; int Xor2 =0;
        ///  find the xor of first natural numbers and xor if xor of all the number present in the array
        for (int i=0; i<N-1; i++){
            Xor2 ^= arr[i];   // xor of all the element of the array
            Xor1 ^= (i+1);   // xor up to [1...N-1]
        }
        ///  in the above loop the Xor1 will get xor up to 1 to N-1 so we have to xor with N also
        Xor1 ^= N;
        /// then return the Xor2 ^ Xor1 will give the result missing number that we are looking for
        return Xor2 ^ Xor1;
    }
    public static void main(String[] args) {
        int[] arr ={1,3,4,5};
        int N = 5;
        System.out.println(Optimal_2MissingNum(arr,N));
    }
}
