package Collections;

import java.util.*;

public class GroupingMaps {
    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1, "A");
        m1.put(2, "B");

        Map<Integer, String> m2 = new HashMap<>();
        m2.put(1, "C");
        m2.put(2, "D");
        Map<Integer, List<String>> map = new HashMap<>();
        for (Integer k : m1.keySet()) {
            String s = m1.get(k);
            if (map.containsKey(k)) {
                List<String> a = map.get(k);
                a.add(s);
                map.replace(k, a);

            } else {
                List<String> a = Arrays.asList(s);
                map.put(k, a);
            }
        }
        for (Integer k : m2.keySet()) {
            String s = m2.get(k);
            if (map.containsKey(k)) {
                List<String> a = map.get(k);
                a.add(s);
                map.replace(k, a);

            } else {
                List<String> a = Arrays.asList(s);
                map.put(k, a);
            }
        }
        for (Integer k : map.keySet()) {
            System.out.println(k + " " + map.get(k));
        }

    }

}
