package org.uycode.p._201_300;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 27/05/2025 17:06:47
 */

public class P236 {

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        TreeNode root = helpers.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        System.out.println(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(6)));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        TreeNode result = new TreeNode(root.val);

        dfs(root, p, q);


        return null;

    }

    public static void dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return;
        System.out.println(node.val);
        dfs(node.left, p, q);
        dfs(node.right, p, q);
    }
}
