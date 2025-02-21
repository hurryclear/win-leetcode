
import java.security.DrbgParameters;

/*
 * @lc app=leetcode id=876 lang=java
 * @lcpr version=30005
 *
 * [876] Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
        // this is tricky and technical problem, key is to use two pointers, one is slow, another is fast
        ListNode slow = head;
        ListNode fast = head;

        // why is this constraint?
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // when fast pointer comes to the end of the list, the slow arrives exactly in the middle of the list
        return slow;

        // need to consider what if there are two middle points and I want to return the first one? constrain of while loop fast != null && fast.next.next != null
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,6]\n
// @lcpr case=end

 */

