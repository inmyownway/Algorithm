import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int answer= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N= Integer.parseInt(bf.readLine());

        board= new int[N][N];

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // 번호 붙이기

        int number=2;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(board[i][j]==1)
                {
                    bfs(i,j,number++);
                }
            }

        }

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(board[i][j]!=0)
                {

                    findWay(i,j,board[i][j]);
                }
            }

        }
        System.out.println(answer);


    }
    public static void findWay(int x,int y,int number)
    {

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{x,y,0});

        boolean[][] v= new boolean[N][N];

        v[x][y]=true;

        while(!q.isEmpty())
        {

            int size= q.size();

            for(int s=0;s<size;s++)
            {int[] now= q.poll();

                if(now[2]> answer)
                {
                    continue;
                }
                for(int idx=0;idx<4;idx++){
                    int nx =now[0]+dx[idx];
                    int ny= now[1]+dy[idx];


                    if(isBoundary(nx,ny) && !v[nx][ny])
                    {
                        if(board[nx][ny]==0)
                        {
                            q.add(new int[]{nx,ny,now[2]+1});

                            v[nx][ny]=true;
                        }
                        else if(board[nx][ny]!=0 && board[nx][ny]!=number)
                        {
                            answer= Math.min(answer,now[2]);

                        }

                    }

                }
            }

        }
    }

    public static void bfs(int x,int y,int number)
    {
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{x,y});

        boolean[][] v= new boolean[N][N];

        v[x][y]=true;
        board[x][y]=number;

        while(!q.isEmpty())
        {
            int[] now= q.poll();

            for(int idx=0;idx<4;idx++){
                int nx =now[0]+dx[idx];
                int ny= now[1]+dy[idx];

                if(isBoundary(nx,ny) && !v[nx][ny] && board[nx][ny]==1)
                {
                    q.add(new int[]{nx,ny});
                    board[nx][ny]=number;
                    v[nx][ny]=true;
                }

            }
        }
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }
    public static void print()
    {
        for(int[]b:board)
        {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }
}