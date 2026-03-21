package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote LeetCode 1980. Find Unique Binary String
 * <p>
 * Given an array of strings nums containing n unique binary strings each of length n,
 * return a binary string of length n that does not appear in nums.
 * If there are multiple answers, you may return any of them.
 * <p>
 * Example 1:
 * Input: nums = ["01","10"]
 * Output: "11"
 * <p>
 * Example 2:
 * Input: nums = ["00","01"]
 * Output: "11"
 * <p>
 * Example 3:
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * <p>
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 16
 * - nums[i].length == n
 * - nums[i] is either '0' or '1'
 * - All the strings of nums are unique
 * @since 08/03/2026 18:41:54
 */

public class P1980 {

    public static void main(String[] args) {
        // Test case 1
        String[] nums1 = {"01", "10"};
        System.out.println("Input: [\"01\", \"10\"]");
        System.out.println("Output: " + findDifferentBinaryString(nums1));
        System.out.println("Expected: \"11\" or \"00\"");
        System.out.println();

        // Test case 2
        String[] nums2 = {"00", "01"};
        System.out.println("Input: [\"00\", \"01\"]");
        System.out.println("Output: " + findDifferentBinaryString(nums2));
        System.out.println("Expected: \"11\" or \"10\"");
        System.out.println();

        // Test case 3
        String[] nums3 = {"111", "011", "001"};
        System.out.println("Input: [\"111\", \"011\", \"001\"]");
        System.out.println("Output: " + findDifferentBinaryString(nums3));
        System.out.println("Expected: \"101\" or \"000\" or \"010\" or \"100\" or \"110\"");
        System.out.println();

        // Test case 4
        String[] nums4 = {"0"};
        System.out.println("Input: [\"0\"]");
        System.out.println("Output: " + findDifferentBinaryString(nums4));
        System.out.println("Expected: \"1\"");
    }

    /**
     * Solution using Cantor's diagonal argument
     * <p>
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the result string
     * <p>
     * The idea is to construct a string where the i-th character is different
     * from the i-th character of the i-th string in nums.
     * This guarantees the result differs from every string in nums at least at one position.
     * <p>
     * For example:
     * nums = ["111", "011", "001"]
     * - At index 0: nums[0].charAt(0) = '1', so we use '0'
     * - At index 1: nums[1].charAt(1) = '1', so we use '0'
     * - At index 2: nums[2].charAt(2) = '1', so we use '0'
     * Result: "000" (which is not in nums)
     */
    public static String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            // Flip the i-th character of the i-th string
            char currentChar = nums[i].charAt(i);
            result.append(currentChar == '0' ? '1' : '0');
        }

        return result.toString();
    }
}
