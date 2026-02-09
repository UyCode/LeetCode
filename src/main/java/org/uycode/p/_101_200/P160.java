package org.uycode.p._101_200;

import org.uycode.common.ListNode;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 21/05/2025 21:56:15
 */

public class P160 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode la = new ListNode(1);
        ListNode lb = new ListNode(8);
        ListNode lc = new ListNode(4);
        ListNode ld = new ListNode(5);
        l1.next = la;
        la.next = lb;
        lb.next = lc;
        lc.next = ld;

        ListNode l2 = new ListNode(5);
        ListNode le = new ListNode(6);
        ListNode lf = new ListNode(1);
        l2.next = le;
        le.next = lf;
        lf.next = lb;

        System.out.println(getIntersectionNode(l1, l2).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {
            if (p != null) {
                p = p.next;
            } else {
                p = headB;
            }

            if (q != null) {
                q = q.next;
            } else {
                q = headA;
            }
        }

        return p;
    }
}
