package org.uycode.p._201_300;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 24/02/2026 13:11:00
 *
 */

public class P222 {

    public static void main(String[] args) {
        Helpers h = new Helpers();
        Integer[] tmp = {1,2,3,4,5,6};
        TreeNode root = h.buildTree(tmp);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        }
        return (1 << rightHeight) + countNodes(root.left);
    }

    private static int getHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}
