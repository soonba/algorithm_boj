package leetcode.p1136479381;

class ListNode {
    final int val;
    final ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calc(l1, l2, false);
    }

    private ListNode calc(ListNode l1, ListNode l2, boolean isUp) {
        int hap = 0;
        boolean up = false;
        hap += l1 == null ? 0 : l1.val;
        hap += l2 == null ? 0 : l2.val;
        ListNode l1Next = l1 == null ? null : l1.next;
        ListNode l2Next = l2 == null ? null : l2.next;

        if (isUp) hap++;

        if (hap >= 10) {
            up = true;
            hap -= 10;
        }

        return (l1 == null && l2 == null)
                ? (isUp
                ? new ListNode(hap, null)
                : null)
                : new ListNode(hap, calc(l1Next, l2Next, up));
    }
}
