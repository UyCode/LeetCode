package org.uycode.contest._177;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 28/02/2026 22:33:22
 *
 */

public class Q1 {
    public static void main(String[] args) {

    }

    public int[] minDistinctFreqPair(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // 统计频率
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 取出去重后的元素并排序
        List<Integer> list = new ArrayList<>(freq.keySet());
        Collections.sort(list);

        int n = list.size();

        // 遍历所有 x < y 的组合
        for (int i = 0; i < n; i++) {
            int x = list.get(i);
            for (int j = i + 1; j < n; j++) {
                int y = list.get(j);
                if (!freq.get(x).equals(freq.get(y))) {
                    return new int[]{x, y};
                }
            }
        }

        return new int[]{-1, -1};

    }
}
