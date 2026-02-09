package org.uycode.p._101_200;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 26/05/2025 16:21:16
 */

public class P102 {


    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        TreeNode root = helpers.buildTree(new Integer[]{1,2,3,4,null,null,5});
        P102 solution = new P102();
        List<List<Integer>> res = solution.levelOrder(root);

        // 
        System.out.println(res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                //if (current == null) continue;
                sub.add(current.val);

                if (current.right != null) {
                    queue.offer(current.right);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
            }

            result.add(sub);
        }


        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        List<Integer> sub = new ArrayList<>();
        if (root.left == null && root.right == null) {
            sub.add(root.val);
            result.add(sub);
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                //if (current == null) continue;
                sub.add(current.val);

                if (current.left != null) {
                    stack.push(current.left);
                }
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
            if (!sub.isEmpty()) {
                result.add(sub);
            }
            sub = new ArrayList<>();

            while (!stack.isEmpty()) {
                size = stack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode current = stack.pop();
                    sub.add(current.val);
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            if (!sub.isEmpty()) {
                result.add(sub);
            }
        }


        return result;
    }

}
