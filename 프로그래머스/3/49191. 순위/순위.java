import java.util.*;
class Solution {
    
    static ArrayList<Integer>[] winner;
    static ArrayList<Integer>[] loser;
    static boolean[] v;
    static int N;
    public int solution(int n, int[][] results) {
        int answer = 0;
        N=n;
        winner = new ArrayList[n+1];
        loser = new ArrayList[n+1];
        
        for(int i=0;i<n+1;i++)
        {
            winner[i]= new ArrayList<>();
            loser[i]= new ArrayList<>();
        }
       

        for(int[] result:results)
        {
            int w = result[0];
            int l = result[1];
            
            winner[l].add(w);
                        loser[w].add(l);
        }
        
        for(int p=1;p<n+1;p++)
        {
            int findStrong=find(p);   
          //  System.out.println(findStrong);
            if(findStrong==N-1)
            {
                answer++;
            }
                
        }
        return answer;
    }
    public static int find(int p)
    {
        v= new boolean[N+1];
        Queue<Integer> q= new LinkedList<>();
        q.add(p);
        
        v[p]=true;
        int cnt=0;
        while(!q.isEmpty())
        {
            
            int now= q.poll();
            
            for(int num: winner[now])
            {
                if(v[num]==false)
                {
                    q.add(num);
                    cnt++;
                    v[num]=true;
                }
            }
        }
        
        
        v= new boolean[N+1];
        q= new LinkedList<>();
        q.add(p);
        
        v[p]=true;
      
        while(!q.isEmpty())
        {
            
            int now= q.poll();
            
            for(int num: loser[now])
            {
                if(v[num]==false)
                {
                    q.add(num);
                    cnt++;
                    v[num]=true;
                }
            }
        }
        return cnt;
        
        
        
        
    }
}