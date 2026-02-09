package org.uycode.p._701_800;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 25/05/2025 13:11:37
 */

public class P704 {

    public static void main(String[] args) {
        System.out.println(search(new int[] {5}, 5));
    }

    public static int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length -1;

        if (target > nums[r] || target < nums[l]) return -1;

        while (l <= r) {
            int mid = l + (r - l) /2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }

        }

        return -1;
    }
}
