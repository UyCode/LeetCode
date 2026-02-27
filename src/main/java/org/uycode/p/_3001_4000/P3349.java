package org.uycode.p._3001_4000;

import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/02/2026 12:26:19
 *
 */

public class P3349 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,4,4,4,5,6,7);
        System.out.println(hasIncreasingSubarrays(nums, 5));
    }

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int start = 0;
        while (start <= nums.size() - 2 * k) {
            // 找第一个序列
            int index = increase(nums, start, start + k);
            if (index != start + k) {
                start = index;
                continue;
            }
            // 找第二个序列
            int index2 = increase(nums, index, index + k);
            if (index2 == index + k) {
                return true;
            }
            if (nums.get(index - 1) < nums.get(index) && index2 + k <= nums.size()) {
                int index3 = increase(nums, index2, index2 + k);
                if (index3 == index2 + k) {
                    return true;
                }
                index2 = index3;
            }
            start = index2;
        }

        return false;

    }
    public static int increase(List<Integer> nums, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return i;
            }
        }
        return end;
    }
}
