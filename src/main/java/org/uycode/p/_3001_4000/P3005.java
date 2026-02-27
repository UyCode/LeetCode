package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/02/2026 10:30:38
 *
 */

public class P3005 {

    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1,2,2,3,1,4}));
    }

    public static int maxFrequencyElements(int[] nums) {

        int[] cnt = new int[100];

        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }

        int max = 1;
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (cnt[i] >= max) {
                if (cnt[i] > max) {
                    sum = 0;
                }
                max = cnt[i];
                sum += max;
            }
        }

        return sum;
    }
}
