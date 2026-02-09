package org.uycode.p._401_500;

import com.sun.source.tree.Tree;
import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/05/2025 20:00:16
 */

public class P0405 {

    public static void main(String[] args) {

        Helpers helpers = new Helpers();
        TreeNode root = helpers.buildTree(new Integer[]{3,null,30,10,null,null,15,null,45});
        TreeNode root2 = helpers.buildTree(new Integer[]{2,1,3});

        P0405 p = new P0405();

        System.out.println(p.isValidBST(root));
        System.out.println(p.isValidBST(root2));
    }

    private static List<Integer> res;
    public boolean isValidBST(TreeNode root) {
        res = new LinkedList<>();
        inOrder(root);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i -1)) return false;
        }
        return true;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }

}
