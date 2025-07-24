#
# @lc app=leetcode id=86 lang=python3
# @lcpr version=30202
#
# [86] Partition List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        # I. partition list
        # 1. two dummy nodes for two temp lists
        dummy1 = ListNode(-1) # l1: value less than x
        dummy2 = ListNode(-1) # l2: value greater or equal than x

        # 2. moving pointers
        p = head # for original list
        p1 = dummy1 # for l1
        p2 = dummy2 # for l2

        # 3. design the loop
        while p is not None:
            if p.val >= x:
                p2.next = p
                p2 = p2.next
            else:
                p1.next = p
                p1 = p1.next
            
            # 4. cut the original list from p1 or p2
            temp = p.next
            p.next = None
            p = temp

        # II. merge two lists
        # 5. merge two lists
        p1.next = dummy2.next
        
        return dummy1.next
        
# @lc code=end



#
# @lcpr case=start
# [1,4,3,2,5,2]\n3\n
# @lcpr case=end

# @lcpr case=start
# [2,1]\n2\n
# @lcpr case=end

#

