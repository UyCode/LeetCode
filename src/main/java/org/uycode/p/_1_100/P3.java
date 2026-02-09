package org.uycode.p._1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 23/05/2025 15:52:45
 */

public class P3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;

        char[] chars = s.toCharArray();
        int ans = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            while (map.get(chars[right]) > 1) {
                map.put(chars[left], map.get(chars[left]) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
