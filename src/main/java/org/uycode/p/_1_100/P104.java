package org.uycode.p._1_100;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/02/2026 11:11:58
 *
 */

public class P104 {

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        Integer[] nodes = {3,9,20,null,null,15,7};
        TreeNode root = helpers.buildTree(nodes);
        System.out.println(maxDepth(root));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);

        return Math.max(maxL, maxR) + 1;
    }

    private static int leftMax = 0;
    private static int rightMax = 0;

    public static void bfs1(TreeNode root) {
        if (root == null) return;
        leftMax++;
        bfs1(root.left);
        bfs1(root.right);
    }
    public static void bfs2(TreeNode root) {
        if (root == null) return;
        rightMax++;
        bfs2(root.left);
        bfs2(root.right);
    }

}
