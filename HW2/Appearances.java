package oop.HW2;

import java.util.*;

public class Appearances {
    public static void main(String[] args) {
        Collection<String> collectionA = List.of("a", "b", "a", "b", "c");
        Collection<String> collectionB = List.of("c", "a", "a", "d", "b", "b", "b");
        int result = sameCount(collectionA, collectionB);
        System.out.println(result);
    }
    public static <T> int sameCount(Collection<T> a, Collection<T> b) {
        Map<T, Integer> freqMapA = new HashMap<>();
        Map<T, Integer> freqMapB = new HashMap<>();
        for (T elem : a) {
            freqMapA.put(elem, freqMapA.getOrDefault(elem, 0) + 1);
        }
        for (T elem : b) {
            freqMapB.put(elem, freqMapB.getOrDefault(elem, 0) + 1);
        }
        int sameCount = 0;
        for (T key : freqMapA.keySet()) {
            if (freqMapB.containsKey(key) && freqMapA.get(key).equals(freqMapB.get(key))) {
                sameCount++;
            }
        }
        return sameCount;
    }
}
