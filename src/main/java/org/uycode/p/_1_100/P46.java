package org.uycode.p._1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/02/2026 13:07:29
 *
 */

public class P46 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> num = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        num = new ArrayList<>();
        for (int i : nums) {
            num.add(i);
        }
        dfs(0);
        return ans;
    }

    private static void dfs(int n) {
        if (n == num.size()-1) {
            ans.add(new ArrayList<>(num));
            return;
        }

        for (int i = n; i < num.size(); i++) {
            swap(i, n);
            dfs(n+1);
            swap(i, n);
        }
    }

    private static void swap (int a, int b) {
        int tmp = num.get(a);
        num.set(a, num.get(b));
        num.set(b, tmp);
    }
}
