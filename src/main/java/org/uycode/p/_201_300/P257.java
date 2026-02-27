package org.uycode.p._201_300;

import org.uycode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 27/02/2026 19:26:12
 *
 */

public class P257 {

    public static void main(String[] args) {

    }

    public static List<String> ans = new LinkedList<>();
    public static List<String> tmp = new LinkedList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();


        return ans;
    }

    private static void dfs(TreeNode root, LinkedList<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null) {

        }
    }
}
