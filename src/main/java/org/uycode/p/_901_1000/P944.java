package org.uycode.p._901_1000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 08/02/2026 10:19:21
 *
 */

public class P944 {

    public static void main(String[] args) {
        String[] strs = {"abc", "bce", "cae"};
        System.out.println(minDeletionSize(strs));
    }


    public static int minDeletionSize(String[] strs) {

        int n = strs.length;
        int m = strs[0].length();
        int ans = 0;

        for (int col = 0; col < m; col++) {
            char prev = strs[0].charAt(col);
            for (int row = 1; row < n; row++) {
                char cur = strs[row].charAt(col);
                if (prev > cur) {
                    ans++;
                    break;
                }
                prev = cur;
            }
        }

        return ans;
    }
}
