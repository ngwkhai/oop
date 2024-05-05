package oop.HW2;

import java.util.*;
public class Taboo<T> {
    private Map<T, Set<T>> map = new HashMap<>();
    public Taboo(List<T> rules) {
        T prev = null;
        for (T rule : rules) {
            if (rule != null) {
                if (prev != null) {
                    Set<T> set = map.get(prev);
                    if (set == null) {
                        set = new HashSet<>();
                        map.put(prev, set);
                    }
                    set.add(rule);
                }
            }
            prev = rule;
        }
    }
    public Set<T> noFollow(T elem) {
        Set<T> result = map.getOrDefault(elem, Collections.emptySet());
        return result;
    }
    public void reduce(List<T> list) {
        ListIterator<T> iterator = list.listIterator();
        T prev = null;
        while (iterator.hasNext()) {
            T curr = iterator.next();
            if (prev != null && map.containsKey(prev) && map.get(prev).contains(curr)) {
                iterator.remove();
            } else {
                prev = curr;
            }
        }
    }
    public static void main(String[] args) {
        List<String> rules = Arrays.asList("a", "c", "a", "b");
        Taboo<String> taboo = new Taboo<>(rules);

        System.out.println(taboo.noFollow("a"));

        List<String> list = new ArrayList<>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        taboo.reduce(list);
        System.out.println(list);
    }
}
