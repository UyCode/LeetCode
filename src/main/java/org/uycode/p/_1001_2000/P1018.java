package org.uycode.p._1001_2000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 09/02/2026 16:52:47
 *
 */

public class P1018 {

    public static void main(String[] args) {
        System.out.println(prefixesDivBy5(new int[]{0, 1, 1}));
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        int x = 0;
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>(n);
        for(int i =0; i < n; i++) {
            x = (x * 2 + nums[i]) % 5;
            ans.add(x == 0);
        }
        return ans;
    }
}
