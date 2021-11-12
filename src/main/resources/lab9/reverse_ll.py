class Solution1:
    
    def helper(self, prev, curr):
        if not curr:
            return prev
            
        if not curr.next:
            curr.next=prev
            return curr        
        tmp = curr.next
        curr.next=prev
        prev = curr
              
        return self.helper(prev, tmp)

    
    def reverseList(self, head):
        
        if not head:
            return head        

        #recursive version
        prev = head
        curr = head.next
        prev.next=None 
        
        return self.helper(prev, curr)
        

