package org.uycode.p._101_200;

import org.uycode.common.TreeNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 15:06:05
 *
 */

public class P108 {

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};

        TreeNode treeNode = sortedArrayToBST(arr);
        System.out.println(treeNode);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) return null;

        return build(nums,0, nums.length-1);
    }

    public static TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }


}
