package org.uycode.p._1001_2000;

import org.uycode.common.Helpers;
import org.uycode.common.TreeNode;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 09/02/2026 11:41:45
 *
 */

public class P1382 {

    public static void main(String[] args) {
        Integer[] nodes = {19,10,null,4,17,null,5};
        Helpers helpers = new Helpers();
        TreeNode treeNode = helpers.buildTree(nodes);
        TreeNode node = balanceBST(treeNode);
        inOrderPrint(node);
    }

    private static int index = 0;
    private static int[] data = new int[10000];

    public static TreeNode balanceBST(TreeNode root) {
        if (isBalanced(root)) return root;
        index = 0;
        data = new int[10000];
        inOrder(root);
        int[] array = new int[index];
        for (int i = 0; i < index; i++) {
            array[i] = data[i];
        }
        Arrays.sort(array);
        return buildBST(array, 0, index - 1);
    }

    private static TreeNode buildBST(int[] arr, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = buildBST(arr, left, mid-1);
        root.right = buildBST(arr, mid+1, right);

        return root;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        data[index++] = root.val;
        inOrder(root.right);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);

        if (leftHeight == -1) return leftHeight;

        int rightHeight = height(root.right);
        if (rightHeight == -1) return rightHeight;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static void inOrderPrint(TreeNode root) {
        if (root == null) return;

        inOrderPrint(root.left);
        System.out.print(root.val + " ");
        inOrderPrint(root.right);
    }
}
