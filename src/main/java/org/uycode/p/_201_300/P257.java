package org.uycode.p._201_300;

import org.uycode.common.Helpers;
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
        Helpers helpers = new Helpers();
        Integer[] tmp = {1,null, null};
        TreeNode root = helpers.buildTree(tmp);
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> ans = new LinkedList<>();
    //public static List<String> tmp = new LinkedList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();
        if (root == null) return ans;
        if (root.left == null && root.right == null) {
            ans.add("1");
            return ans;
        }
        dfs(root, new LinkedList<>());
        return ans;
    }

    private static void dfs(TreeNode root, LinkedList<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0)).append("->");
            for (int i = 1; i < path.size()-1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1));
            ans.add(sb.toString());
            path.removeLast();
            return;
        }
        dfs(root.left, path);
        dfs(root.right, path);

        path.removeLast();

    }
}
