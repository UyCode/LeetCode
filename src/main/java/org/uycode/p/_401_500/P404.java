package org.uycode.p._401_500;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 17:59:17
 *
 */

public class P404 {

    public static void main(String[] args) {

        Helpers helpers = new Helpers();
        Integer[] tmp = {1,2};
        TreeNode root = helpers.buildTree(tmp);

        System.out.println(sumOfLeftLeaves(root));

    }

    private static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {

         if (root.left == null && root.right == null) {
             return 0;
         }

         dfs(root);

         return sum;
    }

    private static void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        }

        dfs(root.left);
        dfs(root.right);

    }
}
