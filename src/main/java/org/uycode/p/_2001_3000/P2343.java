package org.uycode.p._2001_3000;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/05/2025 15:39:19
 */

public class P2343 {

    public static void main(String[] args) {

        String[] nums = {
                "64333639502", "65953866768", "17845691654", "87148775908", "58954177897", "70439926174", "48059986638", "47548857440", "18418180516", "06364956881", "01866627626", "36824890579", "14672385151", "71207752868"
        };

        int[][] q = {
                {9, 4}, {6, 1}, {3, 8}, {12, 9}, {11, 4}, {4, 9}, {2, 7}, {10, 3}, {13, 1}, {13, 1}, {6, 1}, {5, 10}
        };
        System.out.println(Arrays.toString(smallestTrimmedNumbers(nums, q)));
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        List<List<Integer>> list = radixSort(nums);

        int n = queries.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int k = queries[i][0];
            int t = queries[i][1];
            ans[i] = list.get(t - 1).get(k - 1);
        }

        return ans;
    }

    private static List<List<Integer>> radixSort(String[] nums) {
        List<List<Integer>> buckets = new ArrayList<>();
        int n = nums.length;
        int m = nums[0].length();

        for (int i = 0; i < m; i++) {
            List<Integer>[] bucket = new List[10];
            for (int j = 0; j < 10; j++) {
                bucket[j] = new ArrayList<>();
            }
            for (int j = 0; j < n; j++) {
                int idx = i == 0 ? j : buckets.get(i-1).get(j);
                String s = nums[idx];
                bucket[s.charAt(m - i - 1) - '0'].add(idx);
            }

            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                t.addAll(bucket[j]);
            }
            buckets.add(t);
        }

        return buckets;
    }
}
