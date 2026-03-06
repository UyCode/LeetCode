package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 08:38:16
 *
 */

public class P1784 {

    public static void main(String[] args) {
        System.out.println(checkOnesSegment("10"));
    }

    public static boolean checkOnesSegment(String s) {

        if (s.length() == 1) return true;

        char[] chars = s.toCharArray();

        int max = 0;
        int cnt = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '1' && chars[i-1] == '1') {
                cnt++;
                continue;
            }
            max = Math.max(max, cnt);
            cnt = 0;
        }

        if (cnt > 0) max = Math.max(cnt, max);

        return max > 0;
    }
}
