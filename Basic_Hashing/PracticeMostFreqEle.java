package Daily_DSA.Basic_Hashing;


// finding the most frequent element in the array


// first bruteforce approach using visited array
// time complexity is :- O(n*n)
// space complexity is :- O(n) for using a visited array


public class PracticeMostFreqEle {
    static void countfre(int[] arr,int n){
        boolean[] visited = new boolean[n];
        int minfre =n,maxfre=0;             // here we have to take 'minfreq' as large number for easy comparing
        int minele=0,maxele=0;
        for (int i = 0; i < n; i++) {
            // if visited then skip
            if(visited[i]==true){
                continue;
            }
            // if not then count frequency
            int cnt=1;
            for (int j = i+1; j < n; j++) {
                if (arr[j]==arr[i]){
                    visited[j] = true;
                    cnt++;
                }
            }
            if (cnt>maxfre){
                maxfre=cnt;
                maxele=arr[i];
            }
            if (cnt < minfre){
                minfre = cnt;
                minele = arr[i];
            }
        }

        System.out.println("the highest frequency element is "+maxele);
        System.out.println("the highest frequency element is "+minele);
    }
    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};
        int n = arr.length;
        countfre(arr,n);
    }
}
