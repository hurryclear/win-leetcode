/*
 * @lc app=leetcode id=21 lang=java
 * @lcpr version=30005
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1); // dummy node for the new merged list, dummy node is the "head" of the new list, it's not real head... just vitural head
        ListNode p = dummy; // 
        ListNode p1 = list1;
        ListNode p2 = list2;

        // when would while loop end? when anyone of p1 or p2 reach the end
        // when p1 reach the end, p1 == null, and if p2 is not null, then we need to append the rest of p2 to the merged list --> if (p2 != null) p.next = p2; Same for p1
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,4]\n[1,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n[]\n
// @lcpr case=end

// @lcpr case=start
// []\n[0]\n
// @lcpr case=end

 */

