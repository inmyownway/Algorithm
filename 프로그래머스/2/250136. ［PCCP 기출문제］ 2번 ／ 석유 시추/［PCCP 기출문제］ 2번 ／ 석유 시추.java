import java.util.*;
import java.io.*;
class Solution {
    static int N,M;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    
    static boolean[][] v;
    static int label;
    static ArrayList<Integer> arr;
    static Map<Integer,Integer> hs;
    static int[][] map;
    
    public int solution(int[][] land) {
        int answer = 0;
        N= land.length;
        M= land[0].length;
        map= land;
        label=2;
        arr= new ArrayList<>();
        hs = new HashMap<>();
        
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)    
            {
            
                if(map[i][j] !=1) continue;
                int c = check(i,j);
                hs.put(label++,c);
            }
        }
     
        
        Set<Integer> set= new HashSet<>();
        
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(map[j][i]!=0)
                {
                    set.add(map[j][i]);
                }
            }
            
            int currentNum=0;
            for(int num: set)
            {
                currentNum+=hs.get(num);
            }
            answer= Math.max(currentNum,answer);
            set.clear();
        }
    
        return answer;
    }
    public static int check(int a,int b)
    {
        
              
        int cnt=1;
        map[a][b]=label;
        
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{a,b});

  
        while(!q.isEmpty())
        {
            int[] now= q.poll();
            
             int x= now[0];
             int y= now[1];
            
            for(int idx=0;idx<4;idx++){
                int nx= x+dx[idx];
                int ny= y+dy[idx];
                
                if(isBoundary(nx,ny)  && map[nx][ny]==1)
                {
                    q.add(new int[]{nx,ny});
                    
                    map[nx][ny]=label;
                    cnt++;
                }
            }
                
        }
        return cnt;
        
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }
}