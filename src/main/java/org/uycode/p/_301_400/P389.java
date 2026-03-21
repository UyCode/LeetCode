package org.uycode.p._301_400;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 17:42:36
 *
 */

public class P389 {

    public static void main(String[] args) {
        System.out.println(findTheDifference("", "a"));
    }

    /**
     * 给定两个字符串 s 和 t ，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        if (s.isEmpty()) return t.charAt(0);

        int[] cnt = new int[26];
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        for (int i = 0; i < a.length; i++) {
            cnt[a[i] - 'a']++;
            cnt[b[i] - 'a']--;
        }

        cnt[b[b.length-1] - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == -1) return (char) (97 + i);
        }

        return 'a';
    }
}
