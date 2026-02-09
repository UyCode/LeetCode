package org.uycode.p._101_200;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 16:11:23
 *
 */

public class P112 {

    private static int sum =0;

    private static int target = 0;

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = helpers.buildTree(arr);
        System.out.println(pathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) return false;

        target = targetSum;

        int i = bfs(root);

        return i == 10000;

    }

    private static int bfs(TreeNode root) {
        if (root == null) return 0;

        sum += root.val;

        bfs(root.left);
        if (sum == target) return 10000;
        bfs(root.right);
        if (sum == target) return 10000;

        sum -= root.val;

        return sum;

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;


        Stack<State> stack = new Stack<>();
        stack.push(new State(root, root.val, new ArrayList<>(List.of(root.val))));

        while (!stack.isEmpty()) {
            State curr = stack.pop();
            TreeNode node = curr.node;
            int sum = curr.sum;
            List<Integer> path = curr.path;

            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    result.add(path);
                    continue;
                }
            }

            //DFS
            if (node.right != null) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(node.right.val);
                stack.push(new State(node.right, sum + node.right.val, newPath));
            }

            if (node.left != null) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(node.left.val);
                stack.push(new State(node.left, sum + node.left.val, newPath));
            }
        }



        return result;
    }

    public static class State {
        TreeNode node;
        int sum;
        List<Integer> path;

        public State(TreeNode node, int sum, List<Integer> path) {
            this.node = node;
            this.sum = sum;
            this.path = path;
        }
    }
}
