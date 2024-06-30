import java.util.*;

class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int N,M;
    static int[][][] price;
    public int solution(int[][] board) {
 
        N= board.length;
        M=board[0].length;
        price= new int[N][M][4];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
            {
                for(int a=0;a<4;a++)
                {
            price[i][j][a]=Integer.MAX_VALUE;
            
                }}
        }
        bfs(board);
        
   
        int answer= Integer.MAX_VALUE;
        for(int i=0;i<4;i++)
        {
            answer=Math.min(answer,price[N-1][M-1][i]);
        }
        return answer;
    }
   
    public static void bfs(int[][] board)
    {
       /// Queue<Integer> q= new LinkedList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        
        for(int i=0;i<4;i++)
        {
            price[0][0][i]=0;
        }
        
        while(!q.isEmpty())
        {
            int[] now= q.poll();
            int x=now[0];
            int y=now[1];
            for(int idx=0;idx<4;idx++)
            {
                int nx =now[0]+dx[idx];
                int ny= now[1]+dy[idx];
                if(isBoundary(nx,ny) && board[nx][ny]==0)
                {
                    if(now[2]!=idx)
                    {
                        if(price[nx][ny][idx] > price[x][y][now[2]]+100+500)
                        {
                            if(x==0&&y==0)
                            {
                                price[nx][ny][idx]=price[x][y][now[2]]+100;
                            }else{
                            price[nx][ny][idx]=price[x][y][now[2]]+500+100;}
                            q.add(new int[]{nx,ny,idx});
                        }
                    }
                    else{
                            if(price[nx][ny][idx] > price[x][y][now[2]]+100)
                        {
                            if(x==0&&y==0)
                            {
                                price[nx][ny][idx]=price[x][y][now[2]]+100;
                            }else{
                            price[nx][ny][idx]=price[x][y][now[2]]+100;}
                            q.add(new int[]{nx,ny,idx});
                        }
                    }
                }
            }
        }
        
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 &&y<N;
    }


}