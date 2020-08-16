package Java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream<I extends Number> {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("amonkey", "gorrila", "Naman", "monkey");
        List<String> list2 = Arrays.asList("one","two","three");
        List<String> list3 = Arrays.asList("oneOne","2two","3three");
        List<String> list4 = Arrays.asList("one11","two22","three33");
        List<List<String>> listOfList = Arrays.asList(list,list2,list3,list4);
        // FLAT MAP mein x.stream() lag jaata hia
        List<String> finalList = listOfList.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        // Desired Map
        Map<Character, List<String>> desiredMap = finalList.stream().collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println(finalList.stream().collect(Collectors.averagingInt(String::length)));


    }
    public static void mainOcjp(String[] args) {
        List<String> list = Arrays.asList("amonkey", "gorrila", "Naman", "monkey");
        List<String> list2 = Arrays.asList("one", "two", "three");
        List<String> list3 = Arrays.asList("oneOne", "2two", "3three");
        List<String> list4 = Arrays.asList("one11", "two22", "three33");
        //list.stream().map(x -> x.toUpperCase()).forEach(System.out::println);
        List<List<String>> listOfList = Arrays.asList(list, list2, list3, list4);
        List<String> finalList = listOfList.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        // finalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        // finalList.stream().filter(x ->x.length() >= 4).sorted().limit(2).forEach(System.out::println);
        // Isse sort karna hai
        HashMap<Integer, String> desiredMap = finalList.stream().collect(Collectors.toMap(String::length, x -> x, (s1, s2) -> s1 + "," + s2, HashMap::new));
        // UnsuccessFul
        //HashMap<Character,String > desiredMap2 = finalList.stream().collect(Collectors.toMap((String::charAt(0)),x->x, (s1,s2) -> s1 +""+ s2,HashMap::new);
        //Successfull
        //TreeMap<Integer,String> desiredMap = finalList.stream().collect(Collectors.toMap(String::length,x -> x,(s1,s2) -> s1+" "+s2,TreeMap::new));
        //{3=one two, 4=2two, 5=Naman three one11 two22, 6=monkey oneOne 3three, 7=amonkey gorrila three33}
        Map<Integer, List<String>> mapList = finalList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(desiredMap);

        // list.stream().map(String::length).forEach(System.out::println);
        //list.stream().distinct().forEach(System.out::println);
        // String concat = list.stream().reduce("",String::concat);
        // System.out.println(concat);

//        public String encodedAddressUsingTryCatch(String... address) {
//            return Arrays.stream(address)
//                    .map(s -> {
//                        try {
//                            return URLEncoder.encode(s, "UTF-8");
//                        } catch (UnsupportedEncodingException e) {
//                            throw new RuntimeException(e);
//                        }
//                    })
//                    .collect(Collectors.joining(","));
//        }
//
//    }
    }


}
