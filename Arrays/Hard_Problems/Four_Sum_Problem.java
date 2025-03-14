package Daily_DSA.Arrays.Hard_Problems;


///  google Question -> you are given an array you have to find 4 different indexes which will going to give the sum 0


import java.util.*;
public class Four_Sum_Problem {
    ///  this is the brute approach
    /// time -->  O(n^4)
    /// space --> O(no of quads) by using set data structure
    static List<List<Integer>> BruteApproach(int[] arr , int target){
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<=n-1; i++){
            for(int j=i+1; j<=n-1; j++){
                for(int k=j+1; k<=n-1; k++){
                    for(int l=k+1; l<=n-1; l++){
                        if (arr[i]+arr[j]+arr[k]+arr[l] == target){
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            temp.sort(null);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        ans.addAll(set);
        return ans;
    }





    ///  this is the better solution by using the hashing
    /// time --> O(n^3)
    /// space --> O(n) for internal set data structure + O(no of quads) * 2 for returning the answer
    static List<List<Integer>> BetterSolution(int[] arr, int target){
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0; i<=n-1; i++){
            for(int j=i+1; j<=n-1; j++){
                Set<Integer> set = new HashSet<>();
                for(int k=j+1; k<=n-1; k++){
                    int fourth = target - (arr[i] + arr[j] + arr[k]);
                    if (set.contains(fourth)){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
                        temp.sort(null);
                        st.add(temp);
                    }
                    set.add(arr[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(st);
        return ans;
    }



    ///  this is the Optimal approach , this similar like 3 sum , but here i and j are remaining as constants
    /// time --> O(n^2 * n) = O(n^3)
    /// space --> O(no of quads) in order to return the answer , no extra space using to solve the algorithm
    static List<List<Integer>> OptimalApproach(int[] nums, int target){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  // this is very very important
        for(int i=0; i<=n-1; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<=n-1; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }else if(sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(OptimalApproach(arr,target));
    }
}
