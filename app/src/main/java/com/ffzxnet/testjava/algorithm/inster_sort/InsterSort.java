package com.ffzxnet.testjava.algorithm.inster_sort;

/**
 * 插入排序
 * 创建者： feifan.pi 在 2017/8/25.
 */

public class InsterSort {

    public static ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(head.val);
        ListNode pointer = head.next;

        // loop through each element in the list
        while (pointer != null) {
            // insert this element to the new list

            ListNode innerPointer = newHead;
            ListNode next = pointer.next;

            if (pointer.val <= newHead.val) {
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {

                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
                        ListNode oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }

                    innerPointer = innerPointer.next;
                }

                if (innerPointer.next == null && pointer.val > innerPointer.val) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }

            // finally
            pointer = next;
        }

        return newHead;
    }
}
