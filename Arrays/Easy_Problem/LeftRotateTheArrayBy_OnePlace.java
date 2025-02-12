package Daily_DSA.Arrays.Easy_Problem;

///  Question --> rotate the array by one place
/// TC -> O(n)
/// space  --> O(n) bcz we are using the given array in our algo
/// but the Extra space is --> O(1)


public class LeftRotateTheArrayBy_OnePlace {
    static void LeftRotateOnePlace(int[] arr){
        /// we have to shift all the element for one step back
        int n = arr.length;
        int temp= arr[0];
        for (int i = 1;i <= n-1;i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;   /// keep temp element in the last element
    }
    public static void main(String[] args) {
        int[] arr = {1,2,8,4,5};
        LeftRotateOnePlace(arr);
        for (int ele:arr){
            System.out.print(ele+" ");
        }
    }
}
