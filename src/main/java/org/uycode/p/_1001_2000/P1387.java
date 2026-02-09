package org.uycode.p._1001_2000;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/05/2025 19:08:59
 */

public class P1387 {

    public static void main(String[] args) {
        System.out.println(getKth(10, 20, 5));
    }


    public static int getKth(int lo, int hi, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = lo; i <= hi; i++) {
            int count = 0;
            int current = i;
            while (current != 1) {
                if (current % 2 == 0) {
                    current /= 2;
                } else {
                    current = 3 * current + 1;
                }
                count++;
            }
            queue.offer(new int[]{i, count});
        }

        while (k > 1) {
            System.out.println("[" + queue.peek()[0] + ", " + queue.peek()[1] + "]");
            queue.poll();
            k--;
        }


        return queue.poll()[0];

    }
}
