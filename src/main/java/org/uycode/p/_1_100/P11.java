package org.uycode.p._1_100;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 02/02/2026 09:42:36
 *
 */

public class P11 {

    public static void main(String[] args) {

        int[] height = {1,1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {

        int l = 0;
        int r = height.length -1;

        int maxArea = 0;

        while (l < r) {
            int base = r - l;
            int h;

            if (height[l] >= height[r]) {
                h = height[r];
                r--;
            } else {
                h = height[l];
                l++;
            }
            maxArea = Math.max(base * h, maxArea);
        }

        return maxArea;
    }
}
