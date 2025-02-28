import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] A, int[] B) {
        answer = 0;
        
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=B.length-1;i>=0;i--)
        {
            q.add(B[i]);
        }
        
        int idx= A.length-1;
        while(!q.isEmpty())
        {
            
            int nowQ= q.peek();
            //System.out.println("A: "+A[idx]+" B: "+nowQ);
            if(A[idx] < nowQ)
            {
                answer++;
                idx--;
                q.poll();
            }
            else if(A[idx]==nowQ)
            {
                idx--;
                
            }
            else if(A[idx]>nowQ)
            {
                idx--;
            }
            
            if(idx==-1)
            {
                break;
            }
            
        }
        
        return answer;
    }
}