package Array;

import java.util.Map;
import java.util.TreeMap;

// Works only for positive integers
public class SubArrayWithGivenSum {
    public static void findSumNaive(int[] arr, int sum) {
        // Method will print the index
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int currSum = arr[i];
            for (int j = i + 1; j < len; j++) {
                currSum += arr[j];
                if (currSum == sum) {
                    System.out.println("Values matched at index " + i + " and " + j);
                    break;
                }
            }
        }
    }
// Approach 2
public static void subArraySum2(int[] arr, int target) {
    if (arr.length == 0) return;

    int n = arr.length;
    int[] sum = new int[n];
    sum[0] = arr[0];
    for (int i = 1; i < n; ++i) {
        sum[i] = sum[i - 1] + arr[i];
    }

    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; ++i) {
        if (sum[i] == target) {
            System.out.println(0 + " " + i);
        }

        int requiredSum = sum[i] - target;
        if (map.containsKey(requiredSum)) {
            int startIndex = map.get(requiredSum) + 1;
            System.out.println(startIndex + " " + i);
        }
        map.put(sum[i], i);
    }
}

// Approach 3 Windowing

    public static int subArraySum(int arr[], int sum)
    {
        int curr_sum = arr[0], start = 0, i;
        int n = arr.length;
        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum,
            // then return true
            if (curr_sum == sum) {
                int p = i - 1;
                System.out.println(
                        "Sum found between indexes " + start
                                + " and " + p);
                return 1;
            }

            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 7;
        subArraySum(arr, sum);
        subArraySum2(arr, sum);

    }
}
