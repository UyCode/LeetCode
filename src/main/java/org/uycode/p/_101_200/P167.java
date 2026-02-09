package org.uycode.p._101_200;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 22/05/2025 17:58:30
 */

public class P167 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum3(new int[]{3,24,50,79,88,150,345}, 200)));
    }

    public static int[] twoSum2(int[] numbers, int target) {


        for (int i = 0; i < numbers.length-1; i++) {
            int rem = target - numbers[i];
            if (numbers[numbers.length - 1] < rem) continue;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j] == rem) return new int[]{i+1, j+1};
            }
        }

        return null;
    }

    public static int[] twoSum(int[] numbers, int target) {


        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n - 1;
            int rem = target - numbers[i];
            while (l < r) {
                int mid = l + (r - l) /2 + 1;
                if (numbers[mid] == rem) return new int[]{i+1, mid+1};
                if (numbers[mid] < rem) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }

        return new int[]{-1, -1};
    }

    public static int[] twoSum3(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l+1, r+1};
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{-1,-1};
    }
}
