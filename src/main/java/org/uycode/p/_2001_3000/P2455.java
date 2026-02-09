package org.uycode.p._2001_3000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 04/05/2025 16:57:33
 */

public class P2455 {


    public static void main(String[] args) {
        int[] nums = {1,2,4,7,10};
        System.out.println(averageValue(nums));
    }

    public static int averageValue(int[] nums) {

        int sum = 0;
        int count =0;
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum+=num;
                count++;
            }
        }

        if (count == 0) return 0;

        return (int)Math.floor((double) sum /count);
    }
}
