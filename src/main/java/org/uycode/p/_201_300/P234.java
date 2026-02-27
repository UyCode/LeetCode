package org.uycode.p._201_300;

import org.uycode.common.Helpers;
import org.uycode.common.ListNode;

import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 27/02/2026 17:38:06
 *
 */

public class P234 {

    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        int[] tmp = {1,2,3,2,1};
        ListNode head = helpers.buildListNode(tmp);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = slow;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverseListNode(slow);
        fast = head;
        while (reversed != null) {
            if (reversed.val != fast.val) return false;
            fast = fast.next;
            reversed = reversed.next;
        }
        return true;
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;  // Save next node
            curr.next = prev;            // Reverse the link
            prev = curr;                 // Move prev forward
            curr = next;                 // Move curr forward
        }
        return prev;  // New head
    }
}
