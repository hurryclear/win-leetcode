/*
 * @lc app=leetcode id=19 lang=java
 * @lcpr version=30005
 *
 * [19] Remove Nth Node From End of List
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // still not clear why is to use dummy head better and when should i use dummy head?
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = findFromBack(dummy, n + 1); // because i add dummy head, so it is actually (k+1)-th position from back, we count from dummy (-1)
        x.next = x.next.next; // why is .next -> .next.next not ...?

        return dummy.next; // why not head?
    }

    public ListNode findFromBack(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n
// @lcpr case=end

 */

