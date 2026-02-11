package org.uycode.p._3001_4000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 10/02/2026 11:09:20
 *
 */

public class P3318 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findXSum(new int[]{3,8,7,8,7,5}, 2, 2)));
    }

    public static int[] findXSum(int[] nums, int k, int x) {

        int[] cnt;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            cnt = new int[50];
            for (int j = i; j < i+k; j++) {
                cnt[nums[j]]++;
            }
            int tmp = x;
            int sum = 0;
            while (tmp > 0) {
                int max = 0;
                int maxIndex = 0;
                for (int j = 0; j < cnt.length; j++) {
                    if (cnt[j] >= max) {
                        max = cnt[j];
                        maxIndex =j;
                    }
                }
                cnt[maxIndex] = 0;
                sum += max * maxIndex;
                tmp--;
            }
            res.add(sum);
        }

        int[] ans = new int[res.size()];
        int i =0;
        for (Integer sum : res) {
            ans[i++] = sum;
        }

        return ans;
    }
}
