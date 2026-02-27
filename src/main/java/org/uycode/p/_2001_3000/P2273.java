package org.uycode.p._2001_3000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/02/2026 13:14:23
 *
 */

public class P2273 {

    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
    }

    public static List<String> removeAnagrams(String[] words) {

        List<String> ans = new ArrayList<>();
        ans.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!canRemove(words[i], words[i-1])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public static boolean canRemove(String a, String b) {

        if (a.length() != b.length()) return false;
        int[] pos = new int[26];

        int n = a.length();

        for (int i = 0; i < n; i++) {
            pos[a.charAt(i) - 'a']++;
            pos[b.charAt(i) - 'a']--;
        }

        for (int p : pos) {
            if (p != 0) return false;
        }

        return true;
    }
}
