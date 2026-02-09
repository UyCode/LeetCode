package org.uycode.p._101_200;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 16:01:34
 *
 */

public class P110 {

    public static void main(String[] args) {

        Helpers helpers = new Helpers();
        Integer[] arr = {1,2,2,3,3,null,null,4,4};
        TreeNode root = helpers.buildTree(arr);
        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);

        if (leftHeight == -1) return leftHeight;

        int rightHeight = height(root.right);
        if (rightHeight == -1) return rightHeight;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
