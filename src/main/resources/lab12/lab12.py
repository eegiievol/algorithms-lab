class Solution:
    """
    def mergeSort(self, nums, f, l):            
            
            #base case
            if f>=l:
                return             
            if l-f==1:
                if nums[f]>nums[l]:
                    nums[f], nums[l] = nums[l], nums[f]
                return                    
            
            #split in half
            mid = (f+l)//2            
            self.helper(nums, f, mid)
            self.helper(nums, mid+1, l)            
            
            #merge back 2 sorted list
            tmp = []
            i,j = f, mid+1
            while i<mid+1 and j<l+1:
                if nums[i]>nums[j]:
                    tmp.append(nums[j]) 
                    j+=1
                else:
                    tmp.append(nums[i])
                    i+=1
            while i<mid+1:
                tmp.append(nums[i])
                i+=1
            while j<l+1:
                tmp.append(nums[j])
                j+=1 
                
            nums[f:l+1] = tmp[:]
            return
    
    def quickSort(self, nums, f, l):
        #print("f, l, m:",f,l, f+l//2 )
        
        if f>=l:
            return         
        m=(f+l)//2        
        
        if nums[f]>nums[m]:      
            if nums[f]<nums[l]:
                p=f
            elif nums[m]>nums[l]:
                p=m
            else:
                p=l
        else:
            if nums[f]>nums[l]:
                p=f
            elif nums[m]<nums[l]:
                p=m
            else:
                p=l
                     
        #print("p,nums[p]:",p, nums[p])
            
        #swap pivot
        nums[p], nums[l] = nums[l], nums[p]
        i,j = f,l-1
        
        #ctr=0
        while i<=j:
            #ctr+=1
            while nums[i]<nums[l] and i<l:
                i+=1
            while nums[j]>=nums[l] and j>=f:
                j-=1            
            if i<j:
                nums[i], nums[j]= nums[j], nums[i]
                i+=1
                j-=1
        #swap back pivot
        nums[i], nums[p]= nums[p], nums[i]  
        print(nums[f:i])
        print(nums[i+1:l+1])
        #tmp=i
        #while i>f+1 and nums[i]==nums[i-1]:
            #i-=1
        #self.quickSort(nums, f, i-1)
        
        #i=tmp
        #while i<l-1 and nums[i]==nums[i+1]:
            #i+=1        
        self.quickSort(nums, f, i-1) 
        self.quickSort(nums, i+1, l)
    """

    def heapSort(self, nums, len):        
        def heapify(nums, len, i): 
            comparison=0           
            while i*2+1<len:
                m = i*2+1
                comparison += 1
                if i*2+2<len and nums[i*2+2]>nums[i*2+1]:
                    comparison += 1
                    m = i*2+2
                if nums[i]<nums[m]:
                    nums[i], nums[m] = nums[m], nums[i]
                i = m
            return comparison                                 
        
        idx=len
        c = 0
        while idx>0:
            for i in range(idx//2+1, -1, -1):
                c += heapify(nums,idx,i)
            nums[idx-1], nums[0] = nums[0], nums[idx-1]
            idx-=1
        return c
        
    def sortArray(self, nums):       
        
        #self.mergeSort(nums, 0, len(nums)-1)  
        #self.quickSort(nums, 0, len(nums)-1) 

        return self.hearSort(nums, len(nums))

set = [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16],
[2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15],
[4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15],
[5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9]]


for lis in set:
    o = Solution()
    comparisons = o.heapSort(lis, len(lis))
    print("sorted:", lis)
    print("comparisons:", comparisons)
    