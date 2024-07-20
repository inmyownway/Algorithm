from itertools import combinations
def solution(number, k):
    l=[]
    for i in number:
        l.append(i)
    l.sort(reverse=True)
    l=l[:len(number)-k]
    
    answer= ''.join(l)
   
    return answer
    
    
#     for i in number:
#         n.append(i)
        
#     nums=list(combinations(n,len(number)-k))
 
#     max=-129
#     nums.sort(reverse=True)
#     nums=list(nums)

#     temp =list( nums[0])
#     answer=''.join(temp)

    
        
