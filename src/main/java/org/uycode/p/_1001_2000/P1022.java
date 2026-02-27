package org.uycode.p._1001_2000;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 24/02/2026 12:12:47
 *
 */

public class P1022 {

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        Integer[] root1 = {1,0,1,0,1,0,1};
        TreeNode root = helpers.buildTree(root1);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sum = 0;

    public static List<Integer> path = new ArrayList<>(32);

    public static int sumRootToLeaf(TreeNode root) {
        dfs(root);
        return sum;
    }

    private static void calculateSum(List<Integer> path) {
        int tmp = 0;
        for (int bit : path) {
            tmp = (tmp << 1) | bit;
        }
        System.out.println(tmp);
        sum += tmp;
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        path.add(root.val);

        dfs(root.left);
        dfs(root.right);


        if (root.left == null && root.right == null) {
            calculateSum(path);
        }
        path.remove(path.size()-1);
    }
}
