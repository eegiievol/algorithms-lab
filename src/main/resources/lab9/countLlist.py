class Solution2:
    def countList(self, head) -> int:
        if not head:
            return 0
        
        return self.getDecimalValue(head.next)+1
        
        