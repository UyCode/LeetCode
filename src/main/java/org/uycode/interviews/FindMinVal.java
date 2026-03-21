package org.uycode.interviews;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/03/2026 10:43:44
 *
 */

public class FindMinVal {

    public static void main(String[] args) {
        int[] nums = {1,2,5,3,2,1,0,-1,-2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid+1]) {
                l = mid+ 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
