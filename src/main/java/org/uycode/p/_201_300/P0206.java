package org.uycode.p._201_300;

import org.uycode.common.ListNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/05/2025 19:53:12
 */

public class P0206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

    }
    public static boolean isPalindrome(ListNode head) {

        ListNode original = head;
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        StringBuilder oStr = new StringBuilder();

        while (original.next != null) {
            oStr.append(original.val);
            original = original.next;

        }
        oStr.append(original.val);

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        StringBuilder pStr = new StringBuilder();
        while (prev.next != null) {
            pStr.append(prev.val);
            prev = prev.next;
        }
        pStr.append(prev.val);


        return oStr.compareTo(pStr) == 0;
    }

}
