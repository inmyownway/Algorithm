import java.util.*;

class Solution {
    static int[][] v;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static char[][] map;
    static int N,M;
    static int sx,sy,ex,ey;
    static int answer;
    public int solution(String[] board) {
         answer = Integer.MAX_VALUE;
        N = board.length;
        M = board[0].length();
        
        map= new char[N][M];
        v= new int[N][M];
        
        for(int i=0;i<N;i++)
        {
            String str= board[i];
            
            for(int j=0;j<M;j++){
                map[i][j]= str.charAt(j);
                if(map[i][j]=='R')
                {
                
                    map[i][j]= '.';
                    sx= i;
                    sy= j;
                    
                }
            }
        }
        
        
        bfs();
        if(answer== Integer.MAX_VALUE)
            return -1;
//         for(int i=0;i<N;i++)
//         {
// System.out.println(Arrays.toString(v[i]));}
        return answer;
    }
    public static void bfs()
    {
        Queue<int[]> q= new LinkedList<>();
        
        q.add(new int[]{sx,sy,0});
        
        v[sx][sy]=1;
        
        
        while(!q.isEmpty())
        {
            int[] now= q.poll();
            
            int x= now[0];
            int y= now[1];
            int cnt= now[2];
            if(map[x][y]=='G')
            {
                answer= Math.min(cnt,answer);
                continue;
            }
            for(int idx=0;idx<4;idx++)
            {
                int nx=x;
                int ny=y;
                
               
                while(true){
                    
                    nx+=dx[idx];
                    ny+=dy[idx];

                    if(!isBoundary(nx,ny)  || map[nx][ny]=='D')
                    {
                        nx-=dx[idx];
                        ny-=dy[idx];
                        break;
                    }
                 
                }
                if(v[nx][ny]==1)
                {
                    continue;
                }
                else{
                v[nx][ny]=1;
                q.add(new int[]{nx,ny,cnt+1});
                }
                
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }
}