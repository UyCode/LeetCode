package org.uycode.p._801_900;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 22/02/2026 18:34:14
 *
 */

public class P868 {

    public static void main(String[] args) {
        System.out.println(binaryGap(8));
    }

    public static int binaryGap(int n) {

        char[] chars = Integer.toBinaryString(n).toCharArray();
        int l =0;
        int idx = 1;
        int maxGap = 1;
        int current = 1;
        while (idx < chars.length) {
            if (chars[idx] == '0') {
                current++;
            } else {
                l = idx;
                maxGap = Math.max(current, maxGap);
                current = 1;
            }
            idx++;
        }

        return l > 0 ? maxGap: 0;
    }
}
