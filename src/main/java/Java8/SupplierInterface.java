package Java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierInterface {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        Integer highest = Arrays.stream(arr).sorted().min().getAsInt();
        System.out.println(highest);
        Consumer<String> s1 = s -> System.out.println(s);
        s1.accept("Prakhr");

    }
    public static void mainOptional(String[] args) {
        int [] arr = new int[1];
        Optional<Double> optionalDouble = getScores(arr);
        if (optionalDouble.isPresent())
            System.out.println(optionalDouble.get());
    }
    public static Optional<Double> getScores(int [] arr)
    {
        if (arr.length == 0)
            return Optional.empty();
        int sum =0;
        for (int i : arr)
            sum+=i;
        return Optional.of((double)sum/arr.length);
    }

    public static void mainSupplier(String[] args) {
        Supplier<LocalDate> s1 = LocalDate::now;
        for (int i =0;i<100;i++)
       System.out.println(s1.get());

    }

}
