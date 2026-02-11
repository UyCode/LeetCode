package org.uycode.p._101_200;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/02/2026 11:52:15
 *
 */

public class P113 {
    public static void main(String[] args) {
        Helpers helpers = new Helpers();

        Integer[] nodes = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = helpers.buildTree(nodes);
        System.out.println(pathSum(root, 22));

    }

    private static LinkedList<List<Integer>> ans = new LinkedList<>();
    private static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new LinkedList<>();
        path = new LinkedList<>();
        dfs(root, targetSum);
        return ans;
    }

    private static void dfs(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            //currentSum += root.val;
            ans.add(new LinkedList<>(path));
        }

        dfs(root.left, target);

        dfs(root.right, target);

        path.removeLast();
    }
}
