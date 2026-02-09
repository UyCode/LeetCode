package org.uycode.p._401_500;

import org.uycode.common.Helpers;
import org.uycode.common.ListNode;
import org.uycode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 08/05/2025 20:37:44
 */

public class P0403 {

    public static void main(String[] args) {

        Helpers helpers = new Helpers();
        TreeNode root = helpers.buildTree(new Integer[]{1});
        System.out.println(Arrays.toString(listOfDepth(root)));
    }

    public static ListNode[] listOfDepth(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<int[]> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] t = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current == null) continue;
                t[i] = current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            res.add(t);
        }

        ListNode[] result = new ListNode[res.size()];

        for (int i = 0; i < res.size(); i++) {
            int[] temp = res.get(i);
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

            for (int num : temp) {
                current.next = new ListNode(num);
                current = current.next;
            }
            result[i] = dummy.next;

        }

        return result;

    }
}
