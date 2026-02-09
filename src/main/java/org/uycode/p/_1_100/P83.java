package org.uycode.p._1_100;

import org.uycode.common.Helpers;
import org.uycode.common.ListNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 13:24:24
 *
 */

public class P83 {

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        int[] head = {1,1,1,2,3,3};
        ListNode listNode = helpers.buildListNode(head);

        System.out.println(deleteDuplicates(listNode));

    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = head;

        while (dummy.next != null) {
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }


        return head;
    }
}
