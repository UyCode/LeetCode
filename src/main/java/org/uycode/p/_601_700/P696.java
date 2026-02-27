package org.uycode.p._601_700;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 19/02/2026 19:45:05
 *
 */

public class P696 {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }

    public static int countBinarySubstrings(String s) {

        List<Integer> cnt = new ArrayList<>();

        int left = 0;
        int n = s.length();

        char[] chars = s.toCharArray();

        while (left < n) {
            char c = chars[left];
            int count = 0;
            while (left < n && chars[left] == c) {
                left++;
                count++;
            }

            cnt.add(count);
        }

        int ans = 0;
        for (int i = 1; i < cnt.size(); i++) {
            ans += Math.min(cnt.get(i), cnt.get(i-1));
        }


        return ans;
    }
}
