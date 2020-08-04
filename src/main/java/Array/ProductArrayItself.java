package Array;

public class ProductArrayItself {
    /**
     * Try to see the pattern of 1234 to 1126
     * in reverse pass repeat this
     * */
    public static void productionArray (int [] arr)
    {
        int len = arr.length;int i,j,temp;
        int [] res = new int[len];
        for (i=0, temp = 1;i < len;i++)
        {
            res[i] = temp ;  // first pass is equal to
            temp = temp*arr[i];
        }
        for (j=len-1,temp =1;j>=0;j-- )
        {
            res[j] = temp * res[j];
            temp*= arr[j];
        }
        System.out.println("Result is ");
        for (int k: res)
            System.out.println(k);
    }
    public static void main(String[] args) {
        int [] input = {1,2,3,4};
        productionArray(input);
    }

}
