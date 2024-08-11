import java.util.*;
class Solution {
    static int N;
    static int[] cost;
    static ArrayList<Integer>[] arr;
    static boolean[] v;
    static int maxCost=-1;
    public int solution(int n, int[][] edge) {
        
        int answer = 0;
        N= n;
   
        
        arr= new ArrayList[N+1];
        for(int i=0;i<N+1;i++)
        {
            arr[i]= new ArrayList<>();
        }
        
        cost = new int[N+1];
        v= new boolean[N+1];
        
        v[1]=true;
        for(int[] e:edge)
        {
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{1,0});
        
        while(!q.isEmpty())
        {
            int[] now= q.poll();
            int nowNum= now[0];
            int nowCost = now[1];
            maxCost= Math.max(nowCost,maxCost);
            for(int num: arr[nowNum])
            {
                if(!v[num])
                {
                    cost[num]=nowCost+1;
                    v[num]=true;
                    q.add(new int[]{num,nowCost+1});
                }
            }
        }
        for(int i=1;i<N+1;i++)
              {
                  if(cost[i]==maxCost)
                      answer++;
              }
        return answer;
        
        
    }
}