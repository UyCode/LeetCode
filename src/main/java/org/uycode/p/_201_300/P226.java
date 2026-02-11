package org.uycode.p._201_300;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/02/2026 13:51:08
 *
 */

public class P226 {

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        Integer[] nodes = {4,2,7,null,3,6,9};
        TreeNode root = helpers.buildTree(nodes);
        TreeNode inverted = invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node == null || (node.left ==null && node.right == null)) continue;
                TreeNode tmp = node.left;

                node.left = node.right;
                node.right = tmp;

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }

        }

        return root;
    }
}
