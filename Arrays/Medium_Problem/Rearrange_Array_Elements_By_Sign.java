package Daily_DSA.Arrays.Medium_Problem;

import java.util.ArrayList;
import java.util.Arrays;

public class Rearrange_Array_Elements_By_Sign {

    ///  this is the brute approach , here positive and negative numbers are same in the array
    /// time --> O(n) + O(n/2)
    /// space --> O(n/2) + O(n/2) = O(n)  for storing positives and negative numbers in a separate arrays
    static void RearrangeBrute(int[] arr){
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        for (int i=0; i<=arr.length-1; i++){
            if (arr[i] > 0) positives.add(arr[i]);
            else negatives.add(arr[i]);
        }
        System.out.println(positives);
        System.out.println(negatives);

        for (int i=0; i< arr.length/2 ; i++){
            arr[2 * i] = positives.get(i);  // in all even indexes the positive number are appearing
            arr[2 * i +1] = negatives.get(i); // in all odd indexes the negatives numbers are appearing
        }
    }



    /// this is the Optimal solution , here positive and negative numbers are same in the array
    /// time --> O(n) one pass
    /// space --> O(n) in order to return the answer
    static int[] OptimalSolution(int[] arr){
        int n =arr.length;
        int[] AnsArr = new int[n];
        int posIndex =0; int negIndex=1;
        for (int i=0; i<=n-1 ; i++){
            if (arr[i] < 0){
                AnsArr[negIndex] =arr[i];
                negIndex += 2;
            }else{
                AnsArr[posIndex] = arr[i];
                posIndex += 2;
            }
        }
        return AnsArr;
    }




    ///  this is the second verity of this Question , where there is positive and negative numbers are not equal (pos > neg or neg > pos)
    /// time --> O(2n)
    /// space --> O(n) bcz for storing all positives and all negative numbers in a separate arrays
    /// input array --> {-1 ,2,3,4,-3,1}
    static void OptimalVerity_2(int[] arr){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n =arr.length;
        for (int i=0; i<=n-1 ; i++){   // calculating all the positive and negative numbers present in the array
            if (arr[i] > 0){
                pos.add(arr[i]);
            }else{
                neg.add(arr[i]);
            }
        }

        if (pos.size() > neg.size()){  
            for (int i=0; i < neg.size(); i++){
                arr[2 * i] = pos.get(i);
                arr[2 * i +1] = neg.get(i);
            }
            int idx = neg.size() * 2;         
            for (int i = neg.size() ; i <  pos.size() ;i++){    // if elements are remain in the postive list bcz pos.size() > neg.size()
                arr[idx++] = pos.get(i);
            }
        }else{
            for (int i=0; i < pos.size(); i++){
                arr[2 * i] = pos.get(i);
                arr[2 * i +1] = neg.get(i);
            }
            int idx  = pos.size()*2;
            for (int i=pos.size() ; i < neg.size() ; i++){     // if elements are remain in the negative list bcz neg.size()  >  pos.size()
                arr[idx++] = neg.get(i);
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};

        for (int ele : OptimalSolution(arr)){
            System.out.print(ele+ " ");
        }
    }
}
