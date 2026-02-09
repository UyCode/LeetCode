package org.uycode.p._3001_4000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/05/2025 11:48:54
 */

public class P3069 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(resultArray(new int[]{3,1,2,4,6,9,7,8,5})));
    }

    public static int[] resultArray(int[] nums) {

        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];

        int arr1Index = 0;
        int arr2Index = 0;
        for (int i = 2; i < n; i++) {
            if (arr1[arr1Index] > arr2[arr2Index]) {
                arr1Index++;
                arr1[arr1Index] = nums[i];
            } else {
                arr2Index++;
                arr2[arr2Index] = nums[i];
            }
        }

        arr1Index++;
        for (int i = 0; i < n; i++) {
            if (arr2[i] == 0) break;
            arr1[arr1Index + i] = arr2[i];
        }

        /*int[] result = new int[n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr1[i] == 0) {
                index = i;
                break;
            }
                result[i] = arr1[i];
        }

        for (int i = 0; i < n; i++) {
            if (arr2[i] == 0) break;
            result[index + i] = arr2[i];
        }*/


        return arr1;

    }
}
