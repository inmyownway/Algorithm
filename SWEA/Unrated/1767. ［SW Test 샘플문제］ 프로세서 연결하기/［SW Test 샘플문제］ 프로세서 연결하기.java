import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] board;
    static int answerNode;
    static int answerLength;
    static int sideNodeCnt;
    static ArrayList<int[]> arr;
    static int[] dx= {0,0,-1,1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase= Integer.parseInt(bf.readLine());

        for(int t=1;t<testCase+1;t++)
        {
            N=Integer.parseInt(bf.readLine());



            arr = new ArrayList<>();
            answerLength=Integer.MAX_VALUE;
            answerNode= Integer.MIN_VALUE;
            sideNodeCnt=0;
            board = new int[N][N];

            for(int i=0;i<N;i++)
            {
                st = new StringTokenizer(bf.readLine());

                for(int j=0;j<N;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());
                    if(board[i][j]==1)
                    {
                        if( i==0 || i==N-1 || j==0 || j==N-1)
                        {
                            continue;
                        }
                        arr.add(new int[]{i,j});
                      //  System.out.println(i+ " "+j);
                    }

                }
            }

            dfs(0,0);
            System.out.println("#"+t+" "+answerLength);
        }
    }
    private static void dfs(int idx,int nodeCnt)
    {

        if(idx==arr.size())
        {

            int length=0;

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(board[i][j]==2)
                        length++;
                }
            }

            if(nodeCnt == answerNode)
            {
               answerLength=Math.min(answerLength,length);
            }
            else if(nodeCnt > answerNode)
            {
                answerNode=nodeCnt;
                answerLength=length;
            }

            return;
        }


        int[] now =arr.get(idx);



        for(int i=0;i<4;i++)
        {
            boolean flag= false;
            int nx=now[0];
            int ny=now[1];
            int vCnt=0;
            while (true)
            {
                 nx +=dx[i];
                 ny +=dy[i];

                 if(!isBoundary(nx,ny))
                 {
                     flag=true;
                     break;
                 }

                 if(board[nx][ny]!=0)
                    break;

                 board[nx][ny]=2;
                 vCnt++;


            }


            if(flag)
            {

                dfs(idx+1,nodeCnt+1);

            }
            else
            {    nx=now[0];
                ny=now[1];
                for(int j=0;j<vCnt;j++)
                {
                    nx += dx[i];
                    ny += dy[i];
                    board[nx][ny]=0;
                }
                dfs(idx+1,nodeCnt);

            }
            nx=now[0];
            ny=now[1];
            for(int j=0;j<vCnt;j++)
            {
                nx += dx[i];
                ny += dy[i];
                board[nx][ny]=0;
            }


        }

    }
    private static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N &&y>=0 && y<N;
    }


}