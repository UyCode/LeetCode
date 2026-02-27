package org.uycode.p._701_800;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 12/02/2026 09:54:21
 *
 */

public class P717 {

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    public static boolean isOneBitCharacter(int[] bits) {

        int n = bits.length;
        for (int i = 0; i < n; i++) {
            if (bits[i] == 1 && i < n-1) {
                i++;
                continue;
            }
            if (bits[i] == 0 && i == n-1) {
                return true;
            }
        }


        return false;
    }
}
