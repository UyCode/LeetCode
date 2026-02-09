package org.uycode.dp;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 30/04/2025 21:59:19
 */

public class P516 {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubSeq("bbbab"));
    }

    public static int longestPalindromeSubSeq(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) return 1;

        char[] chars = s.toCharArray();

        int left;
        int right;
        int maxLen = 0;

        for (int i = 0; i < chars.length -1; i++) {
            for (int j = i+1; j < chars.length; j++) {
                String temp = s.substring(i, j);
                StringBuilder sb = new StringBuilder(temp);
                if (temp.contentEquals(sb.reverse()) && temp.length() > maxLen) {
                    maxLen = temp.length();
                }
            }
        }

        return maxLen;
    }
}
