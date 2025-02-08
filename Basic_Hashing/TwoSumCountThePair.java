package Daily_DSA.Basic_Hashing;
import java.util.*;


/// Question -->  2 Sum – Count pairs with given sum


// brute-force approach
// it is very naive approach
// time complexity is --> O(n^2)
// space complexity is --> O(1)


public class TwoSumCountThePair {
    static int countPairs(int[] arr,int target){
        int cnt=0;
        for(int i=0;i<arr.length;i++){   //-----------------> O(n)
            for(int j=i+1;j<arr.length;j++){ //--------------> O(n)        total -> O(n)
                if (arr[i]+arr[j]==target){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, -1, 5 };
        int target = 6;
        System.out.println(countPairs(arr, target));

    }
}




// better approach --> using sorting and two pointer technique
// time complexity is --> O(nlogn) + O(n) = O(nlogn)
// space complexity is --> O(1)

class BetterApproachTech{
    static int CountPairs(int[] arr,int target){
        Arrays.sort(arr); /// takes --> O(nlogn)
        int resCnt = 0;
        int left =0;
        int right = arr.length-1;
        while (left < right){
            int sum = arr[left]+arr[right];
            // sum < target move the left pointer
            if (sum<target) left++;
            // sum > target move the right pointer
            else if (sum > target) right --;
            else{
                // sum == target
                // before moving the pointer first check the duplicates in the array
                int cnt1 =0;int cnt2 =0;
                int ele1= arr[left];int ele2 = arr[right];

                // [1,2,2,2,3,3,3,6]  check for this array we have count the no of 2
                while(left <= right && arr[left]==ele1){
                    left++;
                    cnt1++;
                }
                // same for the above array we have to count the no of 3
                while (left<=right && arr[right] == ele2){
                    right--;
                    cnt2++;
                }

                // if the ele1 and ele2 are same means [1,2,2,2,2,5,6]  in this array ele1 = 2 and ele2 = 2
                // the combination can be made by 4 no of 2 C pair of 2 --> 4C2
                if (ele1==ele2) resCnt += (cnt1 * (cnt1-1))/2;
                //if the ele1 and ele2 are not same means [1,2,2,2,3,3,3,6]  in this array ele1 = 2 and ele2 = 3
                // total pairs can be made by cnt1 * cnt2
                else resCnt += cnt2*cnt1;
            }
        }
        return resCnt;
    }
    public static void main(String[] args) {
        int[] arr = { 1,2,2,2,3,3,3,6 };
        int target = 5;
        System.out.println(CountPairs(arr,target));
    }
}





// less optimal approach
// time complexity is :- O(n) + O(n) = O(2n)
// space complexity --> O(k) , k --> no of elements in the frequency map


class LessOptimalApproachTwoSum{
    static int LessOptimalCounter(int[] arr,int target){
        Map<Integer,Integer> FreMap = new HashMap<>();
        // first put all the element in Hashmap
        for(int i=0;i<arr.length;i++){
            FreMap.put(arr[i],FreMap.getOrDefault(arr[i],0)+1); // we know how to put the element in the array , in basic hashing
        }
        // now we are iterating the array to find the pairs
        int pairs =0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]>target) continue;
            int secondVal = target - arr[i];

            // return the secondval frequency ,if secondVal not present give a default value 0
            if (FreMap.getOrDefault(secondVal,0)>0){
                pairs += FreMap.get(secondVal);
                FreMap.put(arr[i],FreMap.get(arr[i])-1);
                if (arr[i] == secondVal){
                    pairs-=1;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3,3,3,6};
        int target = 6;
        System.out.println(LessOptimalCounter(arr,target));

    }
}




// most optimal approach
// time complexity is ---> O(n)
// space complexity is --> O(k) , k --> no of elements in the frequency map

class MostOptimalTwoSum{
    static int GetPairs(int[] arr,int target){
        HashMap<Integer,Integer>  FreMap = new HashMap<>();
        int paris =0;
        for(int i=0;i<arr.length;i++){
            if (arr[i] > target) continue;
            int secondVal = target -arr[i];
            paris += FreMap.getOrDefault(secondVal,0);
            FreMap.put(arr[i],FreMap.getOrDefault(arr[i],0)+1);
        }
        return paris;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        System.out.println(GetPairs(arr,target));
    }
}