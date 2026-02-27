package org.uycode.p._3001_4000;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 12/02/2026 09:07:24
 *
 */

public class P3713 {

    public static void main(String[] args) {
        System.out.println(longestBalanced("zzabccy"));
    }

    public static int longestBalanced(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            int mx = 0, kinds = 0;
            for (int j = i; j < n; j++) {
                int b = s[j] - 'a';
                if (cnt[b] == 0) {
                    kinds++;
                }
                mx = Math.max(mx, ++cnt[b]);
                if (mx * kinds == j - i + 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;

    }
}
