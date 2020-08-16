package Random;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstEvenString {
    public static void main(String[] args) {
        String string = "this is a test string";
        List<String> split = Arrays.stream(string.split(" ")).filter(s ->s.length()%2==0).collect(Collectors.toList());
        split.sort((s1, s2) -> s2.length() -s1.length());
        System.out.println(split.get(0));
    }
}
