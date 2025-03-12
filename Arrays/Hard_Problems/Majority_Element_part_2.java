package Daily_DSA.Arrays.Hard_Problems;

import java.util.*;

///  Find the elements that appears more than N/3 times in the array

public class Majority_Element_part_2 {
    /// this is brute approach
    /// time --> O(n^2)
    /// space --> O(1)
    static List<Integer> BruteApproach(int[] nums){
        // pick up one by one element and check , is it appearing > floor(n/3) or not
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<=n-1; i++){
            int cnt=0;
            for(int j=0; j<=n-1; j++){
                if (nums[i] == nums[j]){
                    cnt++;
                }
            }
            if (cnt > n/3) {
                if(ans.isEmpty() || ans.getLast() != nums[i]){
                    ans.add(nums[i]);
                }
            }
        }
        return ans;
    }




    ///  this is the better approach using the hashing technique
    /// time --> O(n) + O(n) = O(2n) for one iteration on array and another on map
    /// space --> O(n) for using the map
    static List<Integer> betterSolution(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Map<Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<=n-1; i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > n/3){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }




    ///  this is the better approach using the hashing technique
    /// time --> O(n) for one iteration on array
    /// space --> O(n) for using the map
    static List<Integer> betterSolution2(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Map<Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<=n-1; i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) > n/3){
                ans.add(nums[i]);
            }
            if(ans.size() == 2) break; // because I know that the maximum size of the list is 2
        }
        return ans;
    }





    ///  this is the most Optimal solution using moore's voting algorithm with some modification
    /// time --> O(n) + O(n)
    /// space --> O(1)
    static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int cnt1=0;int cnt2=0;
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MAX_VALUE;
        for(int i=0; i<=n-1; i++){
            if(cnt1 == 0 && nums[i] != ele2){ // because currently ele1 is holding the nums[i] element
                cnt1=1;
                ele1 = nums[i];
            }else if(cnt2 == 0 && nums[i] != ele1){ // because currently ele2 is holding the nums[i] element
                cnt2 = 1;
                ele2 = nums[i];
            }else if(ele1 == nums[i]) cnt1++;
            else if(ele2 == nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        // let's check for the manual checking the element stored in the ele1 and ele2 is really our majority element
        // or not
        int count1=0;
        int count2=0;
        for(int i=0; i<=n-1; i++){
            if(ele1 == nums[i]) count1++;
            if(ele2 == nums[i]) count2++;
        }
        if(count1 > n/3) ans.add(ele1);
        if(count2 > n/3) ans.add(ele2);
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(betterSolution2(nums));
    }
}
