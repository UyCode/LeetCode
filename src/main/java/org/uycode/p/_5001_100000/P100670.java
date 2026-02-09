package org.uycode.p._5001_100000;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/05/2025 10:33:29
 */

public class P100670 {

    public static void main(String[] args) {
        System.out.println(minDeletion("abcd", 1));
    }

    public static int minDeletion(String s, int k) {

        Map<Character, Integer> counter = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        if (counter.size() == k) {
            return 0;
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(counter.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        int ans = 0;
        while (entryList.size() > k) {
            Map.Entry<Character, Integer> o = entryList.get(0);
            entryList.remove(o);
            ans += o.getValue();

        }



        return ans;
    }
}
