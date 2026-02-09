package org.uycode.p._1001_2000;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 03/05/2025 13:52:41
 */

public class P1007 {

    public static void main(String[] args) {
        int[] tops = {2,1,2,4,2,2};
        int[] bott = {5,2,6,2,3,2};
        System.out.println(minDominoRotations2(tops, bott));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {

        Map<Integer, Integer> cnt_top = new HashMap<>();
        Map<Integer, Integer> cnt_bot = new HashMap<>();

        int n = tops.length;

        for (int i = 0; i < n; i++) {
            cnt_top.put(tops[i], cnt_top.getOrDefault(tops[i], 0) + 1);
            cnt_bot.put(bottoms[i], cnt_bot.getOrDefault(bottoms[i], 0) + 1);
        }

        Map.Entry<Integer, Integer> max_top = cnt_top.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        Map.Entry<Integer, Integer> max_bot = cnt_bot.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (max_top == null || max_bot == null) return -1;



        int count = 0;
        if (max_top.getKey().equals(max_bot.getKey())) {
            if (max_top.getValue() + max_bot.getValue() < n) return -1;

            if (max_top.getValue() >= max_bot.getValue()) {
                for (int i = 0; i < n; i++) {
                    if (bottoms[i] == max_top.getKey() && tops[i] != max_top.getKey()) {
                        tops[i] = bottoms[i];
                        count++;
                    }
                }
                if (Arrays.stream(tops).allMatch(a -> a == max_top.getKey())) {
                    return count;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (tops[i] == max_top.getKey() && bottoms[i] != max_top.getKey()) {
                        bottoms[i] = tops[i];
                        count++;
                    }
                }
                if (Arrays.stream(bottoms).allMatch(a -> a == max_top.getKey())) {
                    return count;
                }
            }
        } else {
            if (max_top.getValue() >= max_bot.getValue()) {
                for (int i = 0; i < n; i++) {
                    if (tops[i] != max_top.getKey() && tops[i] != bottoms[i]) {
                        tops[i] = bottoms[i];
                        count++;
                    }
                }
                if (Arrays.stream(tops).allMatch(a -> a == max_top.getKey())) {
                    return count;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (bottoms[i] != max_bot.getKey() && bottoms[i] != tops[i]) {
                        bottoms[i] = tops[i];
                        count++;
                    }
                }
                if (Arrays.stream(bottoms).allMatch(a -> a == max_bot.getKey())) {
                    return count;
                }
            }
        }






        return -1;
    }


    public static int max(int[] tops, int[] bottoms) {


        Map<Integer, Integer> cnt = new HashMap<>();

        int n = tops.length;

        for (int i = 0; i < n; i++) {
            cnt.put(tops[i], cnt.getOrDefault(tops[i], 0) + 1);
            cnt.put(bottoms[i], cnt.getOrDefault(bottoms[i], 0) + 1);
        }


        Map.Entry<Integer, Integer> maxEntry = cnt.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (maxEntry == null) return -1;

        if (maxEntry.getValue() < n) return -1;

        int max_top = -1;
        for (int i = 0; i < n; i++) {
            if (tops[i] != maxEntry.getKey() && tops[i] != bottoms[i]) {
                tops[i] = bottoms[i];
                max_top++;
            }

        }
        if (Arrays.stream(tops).anyMatch(a -> a != maxEntry.getKey())) {
            max_top = -1;
        } else {
            max_top++;
        }
        int max_bot = -1;
        for (int i = 0; i < n; i++) {
            if (bottoms[i] != maxEntry.getKey() && bottoms[i] != tops[i]) {
                bottoms[i] = tops[i];
                max_bot++;
            }
        }
        if (Arrays.stream(bottoms).anyMatch(a -> a != maxEntry.getKey())) {
            max_bot = -1;
        } else {
            max_bot++;
        }

        return Math.min(max_top, max_bot);

    }

    /*
    Return min number of rotations
    if one could make all elements in A or B equal to x.
    Else return -1.
    */
    public static int check(int x, int[] A, int[] B, int n) {
        // how many rotations should be done
        // to have all elements in A equal to x
        // and to have all elements in B equal to x
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
            // rotations coudn't be done
            if (A[i] != x && B[i] != x) return -1;
                // A[i] != x and B[i] == x
            else if (A[i] != x) rotations_a++;
                // A[i] == x and B[i] != x
            else if (B[i] != x) rotations_b++;
        }
        // min number of rotations to have all
        // elements equal to x in A or B
        return Math.min(rotations_a, rotations_b);
    }

    public static int minDominoRotations2(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        // If one could make all elements in A or B equal to A[0]
        if (rotations != -1 || A[0] == B[0]) return rotations;
            // If one could make all elements in A or B equal to B[0]
        else return check(B[0], B, A, n);
    }
}
