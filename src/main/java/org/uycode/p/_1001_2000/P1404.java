package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 26/02/2026 13:51:15
 *
 */

public class P1404 {

    public static void main(String[] args) {
        String s = "111";
        System.out.println(numSteps(s));
    }

    public static int numSteps(String s) {

        char[] nums = s.toCharArray();
        int n = nums.length;
        int ans = 0;
        while (!isOne(nums)) {
            ans++;
            if (nums[n-1] == '0') {
                for (int i = n-1; i > 0; i--) {
                    nums[i] = nums[i-1];
                }
                nums[0] = '0';
                continue;
            }

            int idx = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] == '0') {
                    nums[i] = '1';
                    break;
                }
                nums[i] = '0';
                idx++;
            }
            nums[n-1] = '0';
            if(n - idx == 1) {
                char[] newNums = new char[n+1];
                newNums[0] = '1';
                for (int i = 1; i < n+1; i++) {
                    newNums[i] = nums[i-1];
                }
                nums = newNums;
                n++;
            }
        }

        return ans;
    }

    private static boolean isOne(char[] nums) {
        if (nums[nums.length-1] == '0') return false;

        for (int i = nums.length-2; i > 0; i--) {
            if (nums[i] == '1') return false;
        }
        return true;
    }
}
