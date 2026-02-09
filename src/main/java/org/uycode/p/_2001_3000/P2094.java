package org.uycode.p._2001_3000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 12/05/2025 00:06:33
 */

public class P2094 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findEvenNumbers(new int[] { 2, 1, 3, 0 })));
    }

    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        int n = digits.length;

        // Pre-check for minimum requirements (at least 3 digits and at least one even
        // digit)
        boolean hasEven = false;
        for (int d : digits) {
            if (d % 2 == 0) {
                hasEven = true;
                break;
            }
        }
        if (n < 3 || !hasEven)
            return new int[0];

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0)
                continue; // Skip 0 as hundreds digit

            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue; // Different positions

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue; // Different positions

                    if (digits[k] % 2 != 0)
                        continue; // Last digit must be even

                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    result.add(number);
                }
            }
        }

        // Convert to sorted array
        int[] sorted = result.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(sorted);
        return sorted;
    }

    private static int[] allState(int num) {
        int[] result = new int[6];

        int n = 3;
        int[] digits = {
                num / 100,
                (num / 10) % 10,
                num % 10
        };

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;
                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (number % 2 == 0 && number / 100 != 0) {
                        result[index++] = number;
                    }

                }
            }
        }

        return result;
    }
}
