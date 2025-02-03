import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int answer= 0;
    static int[] dx = {0,0,-1,1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int[][] v;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        
        board= new int[N][M];
        v= new int[N][M];
        
        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++)
            {
                board[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(board[i][j]==1)
                {
                    
                    bfs(i,j);
                }
            }
        }
        
          for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                answer= Math.max(v[i][j],answer);
                            }
        }
        System.out.println(answer);
    }
    public static void bfs(int x,int y)
    {
        Queue<int[]> q= new LinkedList<>();
        
        q.add(new int[]{x,y});
        
        while(!q.isEmpty())
        {
            int[] now = q.poll();
            
            int xx= now[0];
            int yy= now[1];
            
            for(int idx=0;idx<8;idx++)
            {
                int nx= xx+dx[idx];
                int ny= yy+dy[idx];
       
                if(isBoundary(nx,ny) && board[nx][ny]==0)
                {
                          
                    if(v[nx][ny]==0 || v[nx][ny] > v[xx][yy]+1)
                    {
                        v[nx][ny]= v[xx][yy]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
      
        
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
        
    }
}
