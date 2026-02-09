package org.uycode.p._301_400;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 21/05/2025 21:13:43
 */

public class P392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        //boolean[] boolS = new boolean[s.length()];

        if (s.isEmpty()) return true;

        int left = 0;
        for (int right = 0; right < t.length(); right++) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                if (left == s.length()) return true;
            }
        }

        return false;
    }

}
