import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N,M;
    static boolean[][] visited;
    static int[][] board;
    static int answerPrice;
    static int answerHomeCnt;
    static int K;
    static int[] dx= {0,0,-1,1};
    static int[] dy ={1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());


        int testCase= Integer.parseInt(st.nextToken());

        for(int test=1;test<testCase+1;test++)
        {
            st= new StringTokenizer(bf.readLine());
            N= Integer.parseInt(st.nextToken());
            M= Integer.parseInt(st.nextToken());

            board= new int[N][N];
            answerPrice=Integer.MIN_VALUE;
            answerHomeCnt=0;
            for(int i=0;i<N;i++)
            {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++)
                {
                    board[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                 //   System.out.println(i+" "+j);
                    check(i,j);

                }

            }
            System.out.println("#"+test+" "+answerHomeCnt);
        }
    }
    private static void check(int x,int y)
    {
        Queue<int[]> q= new LinkedList<>();
        visited= new boolean[N][N];

        q.add(new int[]{x,y});
        visited[x][y]=true;

        K=1;
        int homeCnt=0;
        while(!q.isEmpty())
        {
           // System.out.println();
            //ystem.out.println("단계 "+K);

            int size=q.size();
            for(int s=0;s<size;s++)
            {
                int[] now = q.poll();

                int tx= now[0];
                int ty= now[1];

                if(board[tx][ty]==1)
                {
                    homeCnt++;
                }

                for(int idx=0;idx<4;idx++)
                {
                    int nx= tx+dx[idx];
                    int ny= ty+dy[idx];
                    if(isBoundary(nx,ny) && !visited[nx][ny])
                    {
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }



            if(0 <= M*homeCnt -(K*K+(K-1)*(K-1)))
            {

              answerHomeCnt=Math.max(answerHomeCnt,homeCnt);

            }
            K++;
        }
    }
    private static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }
}