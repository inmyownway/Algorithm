import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] board;
    static int[] dx = { 1, 1, -1, -1 }; // 우하 좌하 좌상 우상
    static int[] dy = { 1, -1, -1, 1 };
    static int maxNum= 0;
    static boolean[][] visited;
    static boolean[] dessert;
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase= Integer.parseInt(bf.readLine());

        for(int t=1;t<testCase+1;t++) {


            N=Integer.parseInt(bf.readLine());
            board = new int[N][N];
            maxNum= 0;

            for(int i=0;i<N;i++)
            {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    visited = new boolean[N][N];
                    dessert = new boolean[101];
                    visited[i][j] = true;
                    dessert[board[i][j]] = true;
                    dfs(1, i, j, i, j, 0);
                }
            }
            if(maxNum==0)
            {
                maxNum=-1;
            }
            System.out.println("#"+t+" "+maxNum);
        }




    }
    public static void dfs(int cnt,int r,int c,int initR,int initC, int prevD)
    {

        for(int i=prevD;i<4;i++)
        {
            int nx=r+dx[i];
            int ny=c+dy[i];

            if(isBoundary(nx,ny))
            {
                if((nx==initR) && (ny== initC) && cnt>2)
                {
                    maxNum=Math.max(cnt,maxNum);
                    return;
                }

                if(!visited[nx][ny] && !dessert[board[nx][ny]])
                {
                    visited[nx][ny]=true;
                    dessert[board[nx][ny]]=true;
                    dfs(cnt+1,nx,ny,initR,initC,i);
                    visited[nx][ny]=false;
                    dessert[board[nx][ny]]=false;

                }
            }
        }
    }


    public static boolean isBoundary(int x,int y)

    {
        return x>=0 && x<N && y>=0&& y<N;
    }


}