package org.uycode.p._2001_3000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 10/05/2025 22:58:41
 */

public class P2918 {

    public static void main(String[] args) {

        int[] num1 = {2, 0, 2, 0};
        int[] num2 = {1, 4};

        System.out.println(minSum(num1, num2));
    }


    public static long minSum(int[] nums1, int[] nums2) {


        long cnt1 = 0L;
        long sum1 = 0L;

        for (int num : nums1) {
            sum1 += num;
            if (num == 0) cnt1++;
        }

        long cnt2 = 0L;
        long sum2 = 0L;

        for (int num : nums2) {
            sum2 += num;
            if (num == 0) cnt2++;
        }

        long min1 = sum1 + cnt1;
        long min2 = sum2 + cnt2;

        if (min1 == min2 || (min1 < min2 && cnt1 > 0) || (min1 > min2 && cnt2 > 0)) {
            return Math.max(min1, min2);
        }


        return -1L;
    }
}
