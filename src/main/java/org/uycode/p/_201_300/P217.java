package org.uycode.p._201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 18/02/2026 12:49:21
 *
 */

public class P217 {

    public static void main(String[] args) {
        System.out.println(containsDuplicateV2(new int[]{1,2,3,1}, 3));
    }

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    public static boolean containsDuplicateV2(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
