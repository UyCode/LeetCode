package org.uycode.p._2001_3000;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 25/05/2025 12:40:41
 */

public class P2131 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"ab", "yt", "ty", "lc", "cl", "gg", "ab"}));
    }

    public static int longestPalindrome(String[] words) {
        int[][] cnt = new int[26][26];
        for (String w : words) {
            cnt[w.charAt(0) - 'a'][w.charAt(1) - 'a']++;
        }

        int ans = 0;
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            int c = cnt[i][i];
            ans += c - c % 2; // 保证结果是偶数，也可以写成 c & ~1
            odd |= c % 2; // 存在出现奇数次的 cnt[i][i]
            for (int j = i + 1; j < 26; j++) {
                ans += Math.min(cnt[i][j], cnt[j][i]) * 2;
            }
        }
        return (ans + odd) * 2; // 上面统计的是字符串个数，乘以 2 就是长度

    }
}
