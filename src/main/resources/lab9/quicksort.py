class Solution:
    def quickSort(self, nums, f, l):
        if f>=l:
            return         
        m=f+l//2
        if nums[f]>nums[m] and nums[f]>nums[l]:      
            if nums[m]>nums[l]:
                p=m
            if nums[l]>=nums[m]:
                p=l
        else:
            p=f  
            
        i,j = f,l-1
        
        while i<=j:
            
            while nums[i]<=nums[p] and i<l-1:
                i+=1
            while nums[j]>=nums[p] and j>f:
                j-=1
            
            if i<j:
                nums[i], nums[j]= nums[j], nums[i]
                i+=1
                j-=1
        nums[i], nums[p]= nums[p], nums[i]  
        
        tmp=i
        while i>f+1 and nums[i]==nums[i-1]:
            i-=1
        self.quickSort(nums, f, i-1)
        
        i=tmp
        while i<l-1 and nums[i]==nums[i+1]:
            i+=1        
        self.quickSort(nums, i+1, l)                
      