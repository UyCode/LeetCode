package org.uycode.p._2001_3000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 09/02/2026 18:16:57
 *
 */

public class P2154 {
    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[]{2,7,9}, 4));
    }

    public static int findFinalValue(int[] nums, int original) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        boolean contains = true;
        while (contains) {
            contains = set.contains(original);
            original *= 2;
        }


        return original/2;
    }
}
