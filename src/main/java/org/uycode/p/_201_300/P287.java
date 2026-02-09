package org.uycode.p._201_300;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 25/05/2025 17:02:52
 */

public class P287 {


    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2,5}));
    }


    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int finder = 0;
        while (slow != finder) {
           finder = nums[finder];
           slow = nums[slow];
        }

        return finder;

    }
}
