package org.uycode.p._101_200;

import org.uycode.common.ListNode;

import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 23/05/2025 15:11:37
 */

public class P142 {

    public static void main(String[] args) {

        ListNode cycle = new ListNode(2);
        ListNode head = new ListNode(3);
        head.next = cycle;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = cycle;
        System.out.println(detectCycle2(head).val);
    }

    public static ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        ListNode dummy = head;

        while (dummy != null) {
            ListNode next = dummy.next;
            if (!set.add(dummy)) return dummy;
            dummy = next;
        }

        return null;
    }


    public static ListNode detectCycle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
