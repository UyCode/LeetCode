package org.uycode.p._301_400;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 01/03/2026 10:24:21
 *
 */

public class P338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 0; i <=n; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                tmp &= (tmp - 1); // 核心：每次消除二进制中最右侧的一个 1
                count++;
            }
            ans[i] = count;
        }

        return ans;
    }
}
