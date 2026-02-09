package org.uycode.p._301_400;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 23/05/2025 14:31:09
 */

public class P337 {

    public static void main(String[] args) {
        P337 p337 = new P337();
        Helpers helpers = new Helpers();
        TreeNode root = helpers.buildTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        System.out.println(p337.rob(root));
    }

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (null == node) return new int[]{0, 0};

        int[] l_rob_and_not = dfs(node.left);
        int[] r_rob_and_not = dfs(node.right);
        int rob = l_rob_and_not[1] + r_rob_and_not[1] + node.val;
        int not_rob = Math.max(l_rob_and_not[0], l_rob_and_not[1]) + Math.max(r_rob_and_not[0], r_rob_and_not[1]);
        return new int[]{rob, not_rob};
    }
}
