package org.uycode.p._301_400;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 09:55:45
 *
 */

public class P350 {

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {2,2,1};

        System.out.println(Arrays.toString(intersect(a, b)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }

        int[] cnt1 = new int[1001];
        int[] cnt2 = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            cnt1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            cnt2[nums2[i]]++;
        }

        int[] tmp = new int[nums1.length];
        int idx =0;
        for (int i = 0; i < 1001; i++) {
            if (cnt1[i] > 0 && cnt2[i] > 0) {
                for (int j = 0; j < Math.min(cnt1[i], cnt2[i]); j++) {
                    tmp[idx++] = i;
                }
            }
        }

        int[] ans = new int[idx];
        System.arraycopy(tmp, 0, ans, 0, idx);

        return ans;
    }
}
