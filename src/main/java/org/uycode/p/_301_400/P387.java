package org.uycode.p._301_400;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class P387 {
    

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char first = '0';
        for (Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                first = entry.getKey();
                break;
            }
        }

        if (first == '0') return -1;

        return s.indexOf(first);
    }
}
