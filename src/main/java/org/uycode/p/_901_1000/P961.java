package org.uycode.p._901_1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P961 {
    

    public static void main(String[] args) {
        int[] arr = {2,1,2,5,3,2};
        System.out.println(repeatedNTimes(arr));
    }

    public static int repeatedNTimes(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int idx = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                idx = entry.getKey();
            }
        }

        return idx;
    }
}
