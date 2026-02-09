package org.uycode.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 05/05/2025 15:05:31
 */

public class Helpers {



    public TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrder[0]);
        queue.offer(root);

        int n = levelOrder.length;


        int index = 1;
        while (!queue.isEmpty() && index < n) {
            TreeNode current = queue.poll();

            if (levelOrder[index] != null) {
                current.left = new TreeNode(levelOrder[index]);
                queue.offer(current.left);
            }
            index++;
            if (index <= n-1 && levelOrder[index] != null) {
                current.right = new TreeNode(levelOrder[index]);
                queue.offer(current.right);
            }
            index++;

        }


        return root;
    }

    public ListNode buildListNode(int[] numbers) {

        ListNode listNode = new ListNode(0);
        ListNode dummy = listNode;

        for (int num : numbers) {
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return listNode.next;
    }
}
