package org.uycode.p._201_300;

import org.uycode.common.Helpers;
import org.uycode.common.ListNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 15/02/2026 12:27:34
 *
 */

public class P203 {

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        ListNode listNode = helpers.buildListNode(new int[]{1,2,2,1});
        ListNode node = removeElements(listNode, 2);
        System.out.println(node);
    }

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }
}
