import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] board;
    static boolean[][] v;
    static int num,cnt;
    static int[] dx= {0,0,-1,1};
    static int[] dy={1,-1,0,0};
     public static void main(String[] args) throws IOException{
        
        
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        
        board= new int[N][M];
        v= new boolean[N][M];
        
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
                if(!v[i][j] && board[i][j]==1)
                {
                    num++;
                    
                    bfs(i,j);
                }
            }
        }
        System.out.println(num);
        System.out.println(cnt);
        
    }
    public static void bfs(int a,int b)
    {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{a,b});
        v[a][b]=true;
        int tempCnt=1;
        
        while(!q.isEmpty()){
            
            int[] now= q.poll();
            
            int x= now[0];
            int y= now[1];
            
            for(int idx=0;idx<4;idx++)
            {
                int nx= x+dx[idx];
                int ny= y+dy[idx];
                
                if(nx>=0 && nx<N && ny>=0 && ny<M)
                {
                    if(!v[nx][ny] && board[nx][ny]==1)
                    {
                        q.add(new int[]{nx,ny});
                        v[nx][ny]=true;
                        tempCnt++;
                    }
                }
            }
         }
        
        cnt= Math.max(cnt,tempCnt);
    }
}
