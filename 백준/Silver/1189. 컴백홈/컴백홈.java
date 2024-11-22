import java.util.*;
import java.io.*;

public class Main {
    static int R,C,K;
    static int sx,sy,ex,ey;
    static char[][] board;
    static int ans;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    
    public static void main(String[] args) throws IOException
    {
        
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        
        board = new char[R][C];
        
        
        for(int i=0;i<R;i++)
        {
        
            String temp= bf.readLine();
                        
            for(int j=0;j<C;j++)
            {
            
                board[i][j] =temp.charAt(j);
                
            }
        }
        
        sx=R-1;
        sy=0;
        
        ex=0;
        ey=C-1;
        
        boolean[][] v= new boolean[R][C];
        
        
        v[R-1][0]=true;
        start(R-1,0,1,v);
        
        System.out.println(ans);
    }
    public static void start(int x,int y,int dis,boolean[][] v)
    {
        //System.out.println(x+" "+y);
       
        if(x==ex && y==ey)
        {
            if(dis==K)
            {
                ans++;
            }
            return;
        }
        for(int idx=0;idx<4;idx++)
        {
            int nx= x+dx[idx];
            int ny= y+dy[idx];
            
            if(isBoundary(nx,ny) && board[nx][ny]=='.'&& !v[nx][ny])
            {
                v[nx][ny]=true;
                start(nx,ny,dis+1,v);
                v[nx][ny]=false;
            }
            
        }
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<R && y>=0 && y<C;
    }
}
