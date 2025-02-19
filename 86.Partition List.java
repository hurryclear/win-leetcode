
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
    /**
     * 1. create two new lists, one to contain greater than or equal to x, another to contain less than x
     * 2. 
     */
    public ListNode partition(ListNode head, int x) {
        // we need two lists, one to contain nodes which value is less than x and another one greater than or equal to x
        // after we divide original list into two lists and then we connect two together into one
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        // use p1 and p2 to move when the two lists grow (dummy node don't move, fixed as "head" node)
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        ListNode p = head; // use p to track the original linked list

        while (p != null) {
            if (p.val >= x) {
                p2.next = p; // connect p2 and p = p2's next points to p
                p2 = p2.next; // move p2 to next node
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            
            // why can't do this? after p1.next = p or p2.next = p, what actually happens? we append p to p1 or p2, right. And assume we had p1.next = p and move to next while loop, what will happend if this time p2.next = p? my original list was appended into p1 list, if we do p2.next = p, then you will get p2 connect with (p1, p) list, because p1 and p now are one list. So to solve this problem, we have to cut the p before we do p2.next = p.
            // p = p.next;

            // p (current) node has been given to p1 or p2, because we knew it's value comparasion result
            ListNode temp = p.next;
            p.next = null; // cut the temp out
            p = temp; // set new p
        }
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

