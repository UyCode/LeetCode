package org.uycode.p._1001_2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 26/01/2026 17:09:31
 *
 */

public class P1200 {


    public static void main(String[] args) {
        int[] arr = {1,3,6,10,15};
        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i+1] - arr[i]);
            if (diff < currentMin) {
                ans = new ArrayList<>();
                ans.add(List.of(arr[i], arr[i+1]));
                currentMin = diff;
                continue;
            }
            if (diff == currentMin) {
                ans.add(List.of(arr[i], arr[i+1]));
            }
        }

        return ans;

    }
}
