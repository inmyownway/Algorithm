import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] board;
    static int[][] holles;
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    static int ex,ey;
    static int answer;
    static boolean[][][] v;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int testCase= Integer.parseInt(st.nextToken());


        for(int test=1;test<testCase+1;test++)
        {   st= new StringTokenizer(bf.readLine());
            N= Integer.parseInt(st.nextToken());

            board= new int[N][N];
            holles= new int[5][4];
            answer=  Integer.MIN_VALUE;
            for(int i=0;i<5;i++)
            {
                holles[i][0]=-1;
                holles[i][1]=-1;
                holles[i][2]=-1;
                holles[i][3]=-1;
            }


            for(int i=0;i<N;i++)
            {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());

                    if(board[i][j]==-1)
                    {
                        ex=i;
                        ey=j;
                    }
                    else if(board[i][j]>=6)
                    {
                        int[] temp= holles[board[i][j]-6];
                        if(temp[0]==-1 && temp[1]==-1)
                        {
                            holles[board[i][j]-6][0]=i;
                            holles[board[i][j]-6][1]=j;
                        }
                        else
                        {
                            holles[board[i][j]-6][2]=i;
                            holles[board[i][j]-6][3]=j;
                        }
                    }
                }
            }

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    //S//.ystem.out.println(i+" "+j);
                    if (board[i][j]==0)
                    {
                        for(int dir=0;dir<4;dir++)
                        {
                            bfs(i,j,dir);
                        }
                    }

                }
            }
            if(answer==Integer.MIN_VALUE)
            {
                System.out.println("#"+test+" "+(0));
            }
            else
                System.out.println("#"+test+" "+answer);
        }


    }
    public static void bfs(int x,int y,int dir)
    {

        int nowX= x;
        int nowY= y;
        int move= 0;
        int score=0;

        while(true)
        {
            if(nowX==x && nowY==y && move!=0)
            {
                break;
            }

            if(board[nowX][nowY]==-1)
                break;

            nowX+=dx[dir];
            nowY+=dy[dir];
            move++;

            if(!isBoundary(nowX,nowY))
            {
                nowX-=dx[dir];
                nowY-=dy[dir];
                dir=isBoundaryChange(dir);
                score++;
            }

            if(board[nowX][nowY] >= 1 && board[nowX][nowY] <=5) {
                int block = board[nowX][nowY];

                dir = changeDir(block,dir);
                score++;
                continue;
            }
            if(board[nowX][nowY]>=6 && board[nowX][nowY]<=10)
            {
                int[] holl = holles[board[nowX][nowY]-6];

                if(nowX == holl[0] && nowY==holl[1])
                {
                    nowX= holl[2];
                    nowY=holl[3];
                }
                else
                {
                    nowX=holl[0];
                    nowY=holl[1];

                }


            }
        }

        answer=Math.max(score,answer);

    }
    public static int changeDir(int blockNum,int dir)
    {
        if(blockNum==1)
        {
            if(dir==0)
                return 1;
            else if(dir==1)
                return 3;
            else if(dir==2)
                return 0;
            else if(dir==3)
                return 2;
        }
        else if(blockNum==2)
        {
            if(dir==0)
                return 3;
            else if(dir==1)
                return 0;
            else if(dir==2)
                return 1;
            else if(dir==3)
                return 2;
        }
        else if(blockNum==3)
        {
            if(dir==0)
                return 2;
            else if(dir==1)
                return 0;
            else if(dir==2)
                return 3;
            else if(dir==3)
                return 1;
        }
        else if(blockNum==4)
        {
            if(dir==0)
                return 1;
            else if(dir==1)
                return 2;
            else if(dir==2)
                return 3;
            else if(dir==3)
                return 0;
        }
        else if(blockNum==5)
        {
            if(dir==0)
                return 1;
            else if(dir==1)
                return 0;
            else if(dir==2)
                return 3;
            else if(dir==3)
                return 2;
        }

        else
            return dir;
   return dir;
    }

    public static void print(int[][] b)
    {
        for(int[] bb:b)
        {
            System.out.println(Arrays.toString(bb));
        }
        System.out.println();
    }

    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }
    public static int isBoundaryChange(int dir) {


        if(dir==0)
            return 1;
        else if(dir==1)
            return 0;
        else if(dir==2)
            return 3;
        else if(dir==3)
            return 2;

        return 0;
    }
}