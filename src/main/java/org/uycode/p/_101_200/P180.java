package org.uycode.p._101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 01/05/2025 23:25:10
 */

public class P180 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(fileCombination(18)));
    }

    public static int[][] fileCombination(int target) {
        //int[][] ans = new int[20][500];

        List<LinkedList<Integer>> ans = new ArrayList<>();

        if (target <= 2) return new int[0][0];

        int n = target/2 + 1;
        int minimum = (int) Math.floor(Math.sqrt(target)) + 1;

        while (n > 0) {
            int current = n;
            if (current < minimum) break;
            int sum = target;
            LinkedList<Integer> temp = new LinkedList<>();
            while (sum  > 0 && current > 0) {
                sum -= current;
                temp.add(current);
                current--;
            }
            if (sum == 0) {
                ans.add(temp);
            }
            n--;
        }

        int[][] res = new int[ans.size()][500];

        for (int i = ans.size() - 1; i >= 0; i--) {
            Object[] array = ans.get(i).toArray();
            res[ans.size() - i - 1] = new int[array.length];
            for (int j = array.length - 1; j >= 0; j--) {
                res[ans.size() - i - 1][array.length - j - 1] = (int)array[j];
            }
        }


        return res;

    }
}
