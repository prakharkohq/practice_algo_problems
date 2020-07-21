package walmart;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 *
 * Word of caution should be only prime factor should be 2 , 3 , 5
 * */
public class UglyNumbers {

    /*****
     *  Hint : Ugly numbers are multiple of each other if u multiply 3 with 3 so 9 is also ugly number
     *
     *  O(n) Solution
     *
     * */
    public static int n = 1;

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(150));
    }
    public static int nthUglyNumber(int n) {
        List<Long> twos = new ArrayList<>();
        twos.add(1L);
        List<Long> threes = new ArrayList<>();
        threes.add(1L);
        List<Long> fives = new ArrayList<>();
        fives.add(1L);

        long minUgly = 0;
        int a = 0, b = 0, c = 0;

        for (int i = 1; i <= n; i++) {
            minUgly = Math.min(twos.get(a), threes.get(b));
            minUgly = Math.min(minUgly, fives.get(c));

            if (minUgly == twos.get(a)) { a++; }
            if (minUgly == threes.get(b)) { b++; }
            if (minUgly == fives.get(c)) { c++; }

            twos.add(minUgly * 2L);
            threes.add(minUgly * 3L);
            fives.add(minUgly * 5L);
        }

        return (int)minUgly;
    }
}
