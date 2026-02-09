package org.uycode.p._101_200;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 14:28:41
 *
 */

public class P104 {

    private static int maxDep = 1;

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        Integer[] nodes = {3,null,1,null,2};
        TreeNode root = helpers.buildTree(nodes);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!queue.isEmpty()) {
                depth++;
            }
        }

        return depth;
    }

    static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        inorder(root.right);
        maxDep++;
    }


}
