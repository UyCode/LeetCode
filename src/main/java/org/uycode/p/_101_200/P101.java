package org.uycode.p._101_200;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 11:37:04
 *
 */

public class P101 {


    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        Integer[] node = {1,2,2,null,3,null,3};
        TreeNode treeNode = helpers.buildTree(node);

        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        if (t1.val != t2.val) return false;

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);

    }

}
