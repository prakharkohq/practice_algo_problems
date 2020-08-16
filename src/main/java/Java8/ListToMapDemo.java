package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Hosting{
    int id;
    String name;
    int webs;

    public Hosting(int id, String name, int webs) {
        this.id = id;
        this.name = name;
        this.webs = webs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWebs() {
        return webs;
    }

    public void setWebs(int webs) {
        this.webs = webs;
    }
}
public class ListToMapDemo {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
       // List<String> finalList = Stream.concat(list1.stream(),list2.stream().collect(Collectors.toList()));
    }
    public static void main1(String[] args) {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "google.com", 80000));
        list.add(new Hosting(2, "twitter.com", 90000));
        list.add(new Hosting(3, "facebook.com", 70000));
        list.add(new Hosting(4, "apple.com", 50000));
        list.add(new Hosting(5, "yahoo.com", 20000));
        list.add(new Hosting(6, "yahoo.com", 40000));

        // Map on ID and name
        Map<Integer,String> resultMap1 = list.stream().collect(Collectors.toMap(Hosting::getId,Hosting::getName));
        System.out.println(resultMap1);

        // Map on Name and websocket
        Map<String,Integer> resultMap2 = list.stream().collect(Collectors.toMap(Hosting::getName,Hosting::getWebs));
        System.out.println(resultMap1);

        // Read name and Websocket distinct

       // Map<String,Integer> resultMap3 = list.stream().collect(Collectors.toMap(Hosting::getName,Hosting::getWebs,(old, newv)->newv));
        //System.out.println(resultMap3);

        Map res5 = list.stream()
                .sorted(Comparator.comparingInt(Hosting::getWebs))
                .collect(Collectors.toMap(Hosting::getName, Hosting::getWebs, (oldv, newv)-> newv+1, LinkedHashMap::new));
        System.out.println("Result5 : "+res5);
    }
}
