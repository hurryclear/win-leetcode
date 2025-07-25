#
# @lc app=leetcode id=23 lang=python3
# @lcpr version=30202
#
# [23] Merge k Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.

import heapq

class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    # define "less than" comparison operator < for the ListNode class
    # when you have two ListNode n1 and n2 objects, you can use n1 < n2 to compare their value
    def __lt__(self, other):
        return self.val < other.val

class Solution:
    # using priority queue (binary heap)
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # 1. lists can't be empty
        if not list:
            return None

        # 2. dummy node
        dummy = ListNode(-1)
        p = dummy

        # 3. define a pq
        pq = []

        # 4. initial min-heap by adding the head of the k lists
        # enumerate(lists) returns pairs of (index, head)
        for i, head in enumerate(lists):
            if head is not None:
                # add a tuple(value, index, node) to the min-heap (pq)
                heapq.heappush(pq, (head.val, i, head))

        # 5. build sorted linked-list by getting elements from min-heap
        while pq:
            val, i, node = heapq.heappop(pq)
            p.next = node
            # ???
            if node.next is not None:
                heapq.heappush(pq, (node.next.val, i, node.next))

            # p moves forward
            p = p.next

        return dummy.next



# @lc code=end



#
# @lcpr case=start
# [[1,4,5],[1,3,4],[2,6]]\n
# @lcpr case=end

# @lcpr case=start
# []\n
# @lcpr case=end

# @lcpr case=start
# [[]]\n
# @lcpr case=end

#

