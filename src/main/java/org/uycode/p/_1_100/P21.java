package org.uycode.p._1_100;

import org.uycode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P21 {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(list1, list2);

        ListNode reverse =reverse(listNode);

        ListNode partition = partition(reverse, 3);

        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                dummy.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        while (list1 != null) {
            dummy.next = new ListNode(list1.val);
            dummy = dummy.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            dummy.next = new ListNode(list2.val);
            dummy = dummy.next;
            list2 = list2.next;
        }


        return result.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    public static ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode();
        ListNode big = new ListNode();

        ListNode s_dummy = small;
        ListNode b_dummy = big;

        while (head != null) {
            if (head.val < x) {
                s_dummy.next = new ListNode(head.val);
                s_dummy = s_dummy.next;
            } else {
                b_dummy.next = new ListNode(head.val);
                b_dummy = b_dummy.next;
            }

            head = head.next;
        }

        s_dummy.next = big.next;
        b_dummy.next = null;

        return small.next;

    }


}
