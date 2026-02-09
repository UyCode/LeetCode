package org.uycode.p._1001_2000;

import java.util.HashSet;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 02/05/2025 13:37:02
 */

public class P1726 {

    public static void main(String[] args) {

    }

    public static List<String> computeSimilarities(int[][] docs) {


        int n = docs.length;

        for (int i = 0; i < n -1; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int value : docs[i]) {
                set.add(value);
            }
            int counter = 0;
            for (int j = i+1; j < n; j++) {
                for(int val: docs[j]) {
                    if (!set.add(val)) {
                        counter++;
                    }
                }
            }

        }


        return null;


    }
}
