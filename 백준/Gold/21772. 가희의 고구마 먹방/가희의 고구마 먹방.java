import java.util.*;
import java.io.*;

public class Main {
    static int R,C,T;
    static char[][] board;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int answer=0;
    public static void main(String[] args) throws IOException{
    
    
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    
    R= Integer.parseInt(st.nextToken());
    C= Integer.parseInt(st.nextToken());
    T= Integer.parseInt(st.nextToken());
    
    board= new char[R][C];
    boolean[][] v= new boolean[R][C];
    int sx=0;
    int sy=0;
    for(int i=0;i<R;i++)
    {
        String str= bf.readLine();
        for(int j=0;j<C;j++)
        {
            board[i][j]= str.charAt(j);
            if(board[i][j]=='G')
            {
                sx=i;
                sy=j;
                board[i][j]='.';
            }
            
        }
    }
    
    v[sx][sy]=true;
    
    
    dfs(sx,sy,0,0,v);
    
    System.out.println(answer);
        
    }
    public static void dfs(int x,int y,int cnt,int time,boolean[][] v)
    {
        if(time==T)
        {
            answer=Math.max(answer,cnt);
            return;
        }
        for(int idx=0;idx<4;idx++)
        {
            int nx = x+dx[idx];
            int ny= y+dy[idx];
            if(!isBoundary(nx,ny) || board[nx][ny]=='#')
            {
                continue;
            }
            
           
            if (board[nx][ny] == 'S') {
                    
                    board[nx][ny] = '.'; // 고구마를 먹은 뒤 빈칸으로 변경
                    dfs(nx, ny, cnt + 1, time + 1, v); // 고구마를 먹고 DFS 진행
                    board[nx][ny] = 'S'; // 탐색이 끝나면 고구마를 원상태로 복구
                } else {
                    // 빈칸으로 이동하는 경우
                    dfs(nx, ny, cnt, time + 1, v);
                }

        }
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<R && y>=0 && y<C;
    }
}