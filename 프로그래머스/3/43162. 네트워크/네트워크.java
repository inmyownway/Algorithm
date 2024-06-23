import java.util.*;
class Solution {
    static boolean[] v;
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        v= new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            if(!v[i])
            {
                
                answer++;
                v[i]=true;
                Queue<Integer> q= new LinkedList<>();
                q.add(i);
                
                while(!q.isEmpty())
                {
                    int node= q.poll();
                    
                    for(int j=0;j<n;j++)
                    {
                        if(computers[node][j]==1 && !v[j])
                        {
                            v[j]=true;
                            q.add(j);
                        }
                    }

                }

            }
        }
        
        return answer;
    }

    
}