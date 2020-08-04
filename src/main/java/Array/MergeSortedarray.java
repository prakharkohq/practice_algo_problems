package Array;

import java.util.Arrays;

public class MergeSortedarray {
    public static int[] mergeArray(int [] arr1, int[] arr2)
    {
        int m = arr1.length; int n = arr2.length;
        int [] result = new int[m+n];
        int i=0, j=0;
        for (int k=0; k < result.length;k++)
        {
            System.out.println(" Value of i "+i +"value of j"+j );
            if ((i< arr1.length)&&(j<arr2.length)&&arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            }
            else
            {
                result[k] = arr2[j];
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,5,7};
        int [] arr2 = {2,4,6,8};
        int [] result = mergeArray(arr, arr2);
        System.out.println(Arrays.toString(result));
    }
}
