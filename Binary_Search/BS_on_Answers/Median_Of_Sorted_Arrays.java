package Daily_DSA.Binary_Search.BS_on_Answers;

///  Question --> to find the median of two sorted Array


public class Median_Of_Sorted_Arrays {
    /// this is the brute force Approach
    /// time -->
    /// space -->
    static double BruteSolution(int[] arr1, int[] arr2){
        // it can be solved if I merge this 2 arrays into third array
        int[] third = new int[arr1.length+arr2.length];
        int i=0,j=0;
        int k=0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                third[k++] = arr1[i++];
            }else{
                third[k++] = arr2[j++];
            }
        }
        while(i<arr1.length){
            third[k++] = arr1[i++];
        }
        while (j < arr2.length){
            third[k++] = arr2[j++];
        }


        // let's check if the length is even or odd
        int totLen = (arr1.length + arr2.length);
        double median=0;
        if (totLen%2 == 0){
            median = (double) (third[totLen/2] + third[(totLen/2)-1])/2;
        }else{
            median = (double) third[totLen/2];
        }
        return median;
    }



    ///  this is the Optimal Solution
    /// time -->
    /// space -->
    public static void main(String[] args) {

    }
}
