package Collections;

import java.util.*;

public class Operation {
    public static void main(String[] args) {
        List<Character> c = new ArrayList<>();
        c.add('a');
        c.add('A');
        c.add('5');
        c.add('Z');
        Set<Integer> set = new HashSet<>();
        for (Character ch : c) {
            set.add(ch - '0');
        }
        set.forEach(System.out::print);

    }

}
