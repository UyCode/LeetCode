package org.uycode.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/03/2026 09:40:31
 *
 */

public class Merging {

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size()-1)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], interval[1]);
            }
        }

        return result.toArray(new int[0][]);
    }
}
