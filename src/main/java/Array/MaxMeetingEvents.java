package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxMeetingEvents {
    public static void main(String[] args) {
        int [] arr = {1,2,3,3,3};
        int [] dep = {2,2,3,4,4};
        int [][] result = convertArray(arr, dep);
        System.out.println(maxEvents(result));
        //System.out.println(Arrays.deepToString(result));
    }
    public static int[][] convertArray(int [] arr,int[] dep)
    {
        int [][] result = new int[arr.length][2];
        for (int i=0;i < arr.length;i++)
        {
            result[i][0] = arr[i];
            result[i][1] = dep[i];
        }
        return result;
    }

    public static int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = A.length;
        for (int d = 1; d <= 100000; ++d) {
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            while (i < n && A[i][0] == d)
                pq.offer(A[i++][1]);
            if (!pq.isEmpty()) {
                pq.poll();
                ++res;
            }
        }
        return res;
    }

    public int maxEvents2(int[][] events) {
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        int eventIndex = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = Integer.MIN_VALUE;
        int result = 0;
        while (eventIndex != events.length || !pq.isEmpty()) {
            while (eventIndex != events.length && events[eventIndex][0] == day) {
                pq.offer(events[eventIndex][1]);
                ++eventIndex;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                ++day;
                ++result;
            } else if (eventIndex != events.length) {
                day = events[eventIndex][0];
            }
        }

        return result;
    }
}
