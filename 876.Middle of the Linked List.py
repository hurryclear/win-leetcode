#
# @lc app=leetcode id=876 lang=python3
# @lcpr version=30202
#
# [876] Middle of the Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    # slow and fast pointer

    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:

        # 1. dummy node
        dummy = ListNode(-1)
        dummy.next = head

        # 2. moving node p1, p2
        p1 = head
        p2 = head
        
        # 3. p1 moves one step and p2 moves two steps
        while p2 is not None and p2.next is not None:
            p1 = p1.next
            p2 = p2.next.next

        return p1
        
# @lc code=end



#
# @lcpr case=start
# [1,2,3,4,5]\n
# @lcpr case=end

# @lcpr case=start
# [1,2,3,4,5,6]\n
# @lcpr case=end

#

