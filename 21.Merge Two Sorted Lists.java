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

        // 1. dummy node
        // dummy node for the new merged list, dummy node is the "head" of the new list, it's not real head
        // a virtual head
        // why -1? 
        ListNode dummy = new ListNode(-1);

        // 2. pointers
        // assign pointer for each list, these pointers will need to move all the time
        // that's why we need to assign pointers
        ListNode p = dummy; 
        ListNode p1 = list1;
        ListNode p2 = list2;

        // 3. design the while loop
        /*
         * consideration:
         * p1 and p2 will move forward until when?
         * when would while loop end? when anyone of p1 or p2 reach the end
         * there could be different situations:
         *      - p1 and p2 reach to the end together
         *      - p1 reach to the end first:
         *        when p1 reach the end, p1 == null, and if p2 is not null, then we need to append the rest of p2 to the merged list --> if (p2 != null) p.next = p2; Same for p1
         *      - p2 reach to the end first
         */
        // loop ends when anyone of p1 and p2 reach to the end
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) { // compare the value of the current node
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        
        // 4. append the rest of the list (the one hasn't reached to the end) to the new list
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        // 5. return the head of the new list
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

