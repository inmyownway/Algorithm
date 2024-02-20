import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution {

    static int N,W,H;
    static int[][] board;
    static int answer;
    static int[] numbers;
    static int[][] copy;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException
    {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int testCase= Integer.parseInt(bf.readLine());

        for(int tc=0;tc<testCase;tc++)
        {

            st= new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());
            H=Integer.parseInt(st.nextToken());

            board = new int[H][W];
            copy = new int[H][W];
            numbers= new int[N];
            for(int i=0;i<H;i++)
            { st= new StringTokenizer(bf.readLine());
                for(int j=0;j<W;j++)
                {
                    board[i][j]=copy[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            answer=Integer.MAX_VALUE;


            perm(0);
            System.out.println("#"+(tc+1)+" "+answer);
        }

    }
    public static void perm(int cnt)
    {
        if(cnt==N)
        {

            bomb(numbers);

            int tmp=0;
            for(int i=0;i<H;i++)
            {
                for(int j=0;j<W;j++)
                {
                 if(board[i][j]!=0)
                     tmp++;
                }
            }
          // System.out.println(tmp);
            answer=Math.min(answer,tmp);

            for(int i=0;i<H;i++)
            {
                for(int j=0;j<W;j++)
                {
                  board[i][j]=copy[i][j];
                }
            }

            return;
        }
        for(int i=0;i<W;i++)
        {
            numbers[cnt]=i;
            perm(cnt+1);
        }
    }

    public static void bomb(int[] nums)
    {
        int x= 0;
        int y= 0;

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<H;j++)
            {
                if(board[j][nums[i]]!=0)
                {
                    x=j;
                    y=nums[i];
                    break;
                }
            }
            bfs(x,y);
            blockdown();
        }



    }
    public static void bfs(int x,int y)
    {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,board[x][y]});
        board[x][y]=0;
        while(!q.isEmpty())
        {
            int[] now = q.poll();

            int cx= now[0];
            int cy= now[1];
            int range= now[2];

            for(int i=1;i<range;i++)
            {
                for(int j=0;j<4;j++)
                {
                    int nx= cx+ dx[j]*i;
                    int ny= cy+dy[j]*i;

                    if(isBoundary(nx,ny) && board[nx][ny]!=0)
                    {
                        q.add(new int[]{nx,ny,board[nx][ny]});
                        board[nx][ny]=0;
                    }
                }
            }
        }
    }

    public static void blockdown()
    {


        for(int y=0;y<W;y++)
        {
            for(int x=H-2;x>-1;x--)
            {
                if(board[x][y]!=0) {
                    // j= x = 1
                    // i = y = 0
                    int idx = 0;

                    while (true) {
                        int nx = x+idx;
                        if (nx+1>=H || board[nx+1][y] != 0) {


                            break;
                        } else {
                            board[nx+ 1][y] = board[nx][y];
                            board[nx ][y] = 0;
                            idx++;
                        }
                    }
                }

            }
        }
    }

    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<H && y>=0 && y<W;
    }

    public static void print(int[][] a)
    {
        for(int[]b:a)
        {
            System.out.println(Arrays.toString(b));
        }
    }
}