package org.uycode.dp;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 28/04/2025 20:23:42
 */

public class P5 {


    public String longestPalindrome1(String s) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        char[] chars = s.toCharArray();
        int n = s.length();
        int left;
        int right;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            left = i - 1;
            right = i + 1;
            int c = chars[i];
            while (left >= 0 && chars[left] == c) {
                len++;
                left--;
            }
            while (right < n && chars[right] == c) {
                len++;
                right++;
            }
            while (left >= 0 && right < n && chars[left] == chars[right]) {
                len += 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
                if (maxLen == n) break;
            }
            len = 1;
        }

        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
