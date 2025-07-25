#
# @lc app=leetcode id=19 lang=python3
# @lcpr version=30202
#
# [19] Remove Nth Node From End of List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # 1. dummy node
        dummy = ListNode(-1)
        dummy.next = head

        # 2. find the n-th node from end
        # x = findFromEnd(head, n)
        # you have to start from dummy node not head, why?
        # because we actually find the (n+1)-th node from end
        # so later we can easily remove n-th node
        # by x.next=x.next.next ==> we "jump" over the n-th node from end
        x = self.findFromEnd(dummy, n+1)

        # 3. remove the n-th node from end
        # we "jump" over the n-th node from end
        x.next = x.next.next

        # 4. return result
        return dummy.next

    def findFromEnd(self, head: ListNode, k: int) -> ListNode:
        # 1. get two pointers 
        p1 = head
        p2 = head

        # 2. let p1 move k steps
        for i in range(k):
            p1 = p1.next
        
        # 3. let p1 and p2 move together until p1 gets to the end/null
        while p1 != None:
            p1 = p1.next
            p2 = p2.next
        
        # 4. return p2 and it's at the exact position we want
        return p2


        
# @lc code=end



#
# @lcpr case=start
# [1,2,3,4,5]\n2\n
# @lcpr case=end

# @lcpr case=start
# [1]\n1\n
# @lcpr case=end

# @lcpr case=start
# [1,2]\n1\n
# @lcpr case=end

#

