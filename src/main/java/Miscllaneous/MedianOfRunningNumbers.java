package Miscllaneous;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfRunningNumbers {
    /**
     * Using the concept of min heap and max heap for solving this problem
     * <p>
     * For more :  https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/
     */
    public static PriorityQueue<Long> minHeap = new PriorityQueue<>();
    public static PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void addNumber(long i) {
        /*
        * Always remeber the first number case
        * */
        minHeap.offer(i);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size() < maxHeap.size())
        {
            minHeap.offer(maxHeap.poll());
        }
    }
    public static long getMedian()
    {
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else
        {
            return  (minHeap.peek()+maxHeap.peek())/2;
        }
    }

    public static void main(String[] args) {
        long [] a = {1,5,3,7,8,9};
        for (long i : a)
        {
            addNumber(i);
        }
        System.out.println(getMedian());
    }
}
