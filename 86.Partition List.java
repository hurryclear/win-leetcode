
import java.awt.geom.Path2D;
import java.security.PKCS12Attribute;

/*
 * @lc app=leetcode id=86 lang=java
 * @lcpr version=30005
 *
 * [86] Partition List
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
    /*
     * consideration:
     * 1. partition the list into two lists, one with value less than x and the other greater or equal than x
     * 2. merge the lists
     */
    public ListNode partition(ListNode head, int x) {

        // 1. dummy node for two new lists
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        // 2. moving pointers: p1 and p2
        ListNode p1 = dummy1; // value less than x
        ListNode p2 = dummy2; // value greater or equal than x

        // 3. pointer p for original list
        ListNode p = head; // use p to track the original linked list

        // 4. design the loop
        // 4.1 when would the loop stop?
        while (p != null) { // loop ending requirement
            if (p.val >= x) {
                p2.next = p; // append p to p2 (the whole original list will be appended)
                p2 = p2.next; // move p2 to the next
            } else {
                p1.next = p; // append p to p1 (the whole original list will be appended)
                p1 = p1.next; // move p2 to the next
            }
            
            // 5. cut the original list from p1 or p2
            ListNode temp = p.next;
            p.next = null; // cut the temp out
            p = temp; // set new p

            // ???
            // why can't do this? after p1.next = p or p2.next = p, what actually happens? we append p to p1 or p2, right. And assume we had p1.next = p and move to next while loop, what will happend if this time p2.next = p? my original list was appended into p1 list, if we do p2.next = p, then you will get p2 connect with (p1, p) list, because p1 and p now are one list. So to solve this problem, we have to cut the p before we do p2.next = p.
            // p = p.next;
        }
        // 6. merge two lists (l1 + l2)
        // how to connect two lists? connect p1 with the (actual) head node of p2, so it's dummy2.next (that's also the advantage of using dummy node, it's easy to find head node of list)
        p1.next = dummy2.next;

        return dummy1.next; // return actual head node
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,4,3,2,5,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [2,1]\n2\n
// @lcpr case=end

 */

