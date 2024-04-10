import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static char[][] board;

    static int[] dx= {0,0,-1,1};
    static int[] dy= {1,-1,0,0};
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input="";
        int testCase=0;
        while ((input = bf.readLine() )!= null)
        {
            st= new StringTokenizer(input);
            N= Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            visited= new boolean[N][M];
            board= new char[N][M];
            answer= Integer.MAX_VALUE;
            for(int i=0;i<N;i++)
            {
                String str= bf.readLine();
                for(int j=0;j<M;j++)
                {
                    board[i][j]=str.charAt(j);
                    if(board[i][j]=='*')
                        visited[i][j]=true;
                }
            }

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    if(board[i][j]=='.')
                    {
                        visited = new boolean[N][M];
                        visited[i][j]=true;
                        go(i,j,0,visited);
                        visited[i][j]=false;
                    }

                }

            }
            testCase++;
            if (answer==Integer.MAX_VALUE)
                answer= -1;
            System.out.println("Case "+testCase+": "+answer);
        }



    }

    private static void go(int x, int y, int cnt, boolean[][] v) {


        if(check(v))
        {
            answer=Math.min(answer,cnt);
            return;
        }



        for(int idx=0;idx<4;idx++)
        {
            int nx= x;
            int ny= y;
            int s=0;

            while (true)
            {
                int tx= nx+dx[idx];
                int ty= ny+dy[idx];

                if(!isBoundary(tx,ty) || board[tx][ty]=='*' || v[tx][ty])
                {
                    break;
                }

                s++;
                v[tx][ty]=true;
                nx=tx;
                ny=ty;
            }

            if(nx== x && ny==y)
                continue;
            go(nx,ny,cnt+1,v);

            nx= x;
            ny= y;
            for(int i=0;i<s;i++)
            {
                nx+=dx[idx];
                ny+=dy[idx];
                visited[nx][ny]=false;
            }
        }
    }

    private static boolean check(boolean[][] v) {
        boolean flag= true;

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(board[i][j]=='.' && v[i][j]==false)
                    flag=false;
            }
        }
        return flag;
    }


    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }

}