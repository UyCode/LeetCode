package org.uycode.p._801_900;

import org.uycode.common.Helpers;
import org.uycode.common.ListNode;
import org.uycode.common.TreeNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 21/05/2025 21:28:38
 */

public class P876 {

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        ListNode listNode = helpers.buildListNode(new int[]{1,2,3,4,5});
        ListNode res = middleNode(listNode);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
