import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Queue<Integer> q=new LinkedList<>();
        int N= A.length;
        for(int i=N-1;i>-1;i--)
        {
            q.add(A[i]);
        }
        
        Arrays.sort(B);
        ArrayDeque<Integer> dq= new ArrayDeque();
        for(int i=0;i<N;i++)
        {
            dq.add(B[i]);
        }
        while(!q.isEmpty()){
            int now= q.poll();
            
            if(now < dq.peekLast())
            {
                dq.pollLast();
                answer++;
            }
            else
            {
                dq.pollFirst();
            }
        }
        
        return answer;
    }
}