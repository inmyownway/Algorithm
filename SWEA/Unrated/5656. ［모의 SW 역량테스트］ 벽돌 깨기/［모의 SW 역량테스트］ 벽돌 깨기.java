import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N,W,H;
    static int[][] board;
    static int answer;
    static Queue<Bomb> q;
    static int answerCnt;
    static int[][] temp;
    static boolean[] v;
    static int[] nums;
    static class Bomb{
        int x;
        int y;
        int size;

        @Override
        public String toString() {
            return "Bomb{" +
                    "x=" + x +
                    ", y=" + y +
                    ", size=" + size +
                    '}';
        }

        public Bomb(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase= Integer.parseInt(bf.readLine());



        for(int t=1;t<testCase+1;t++)
        {
            st= new StringTokenizer(bf.readLine());
            N= Integer.parseInt(st.nextToken());
            W= Integer.parseInt(st.nextToken());
            H= Integer.parseInt(st.nextToken());
            board= new int[H][W];
            temp = new int[H][W];
            answer= Integer.MAX_VALUE;
            v= new boolean[W];
            answerCnt=0;
            nums= new int[N];

            for(int i=0;i<H;i++)
            {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<W;j++)
                {
                  temp[i][j]=  board[i][j]=Integer.parseInt(st.nextToken());
                }

            }



            // 0~ W 까지 순열 구하기 ㅓ디 떨어트릴지
            // 쏘기
            // 만약 1보다 크면 큐에넣고, 연쇄반응 시작

            // 4방향으로 수만큼 터트릭 큐에 넣기


            perm(0);
            System.out.println("#"+t+" "+answer);

        }
    }
    private static void perm(int depth)
    {

        if(answer==0)
            return;
        if(depth==N)
        {
        for(int a=0;a<H;a++)
        {
            for(int b=0;b<W;b++)
            {
                board[a][b]=temp[a][b];
            }
        }
            answerCnt=0;
            check(nums);
           // System.out.println(answerCnt);
            return;
        }

        for(int i=0;i<W;i++)
        {
            nums[depth]=i;
            perm(depth+1);
        }

    }
    private static void check(int[] marble)
    {
        q= new LinkedList<>();
     //   System.out.println(Arrays.toString(marble));
        for(int i=0;i<N;i++)
        {
            // 폭탄 쏘는곳

            for(int idx=0;idx<H;idx++)
            {
                if (board[idx][marble[i]] != 0)
                {
                    q.add(new Bomb(idx,marble[i],board[idx][marble[i]]));
                    //System.out.println(idx+" "+marble[i]);
                    crash();
                    break;
                }


            }

            // 폭탄내리기

//            System.out.println("내린후");

              nextState();

//            for(int[]b:board)
//            {
//                System.out.println(Arrays.toString(b));
//            }
//            System.out.println();
        }
     //   System.out.println(answerCnt);
       int remainBomb=0;
        for(int a=0;a<H;a++)
        {
            for(int b=0;b<W;b++)
            {
                if(board[a][b]!=0)
                {
                    remainBomb++;
                }
            }
        }
        answer= Math.min(answer,remainBomb);
        if(answer==0) return;
    }

    private static void nextState() {

        for(int j=0;j<W;j++)
        {
            for(int i=H-2;i>-1;i--)
            {
                if(board[i][j]!=0)
                {
                    int num= board[i][j];

                    int idx=1;
                    while (i+idx<=H-1)
                    {
                        if(board[i+idx][j]==0)
                        {
                            board[i+idx][j]=num;
                            board[i+idx-1][j]=0;
                            idx++;
                        }
                        else
                        {
                            break;
                        }

                    }
                }
            }
        }
    }

    private static void crash() {

        int[] dx= {0,0,-1,1};
        int[] dy={1,-1,0,0};

        while(!q.isEmpty())
        {
            Bomb now = q.poll();

            board[now.x][now.y]=0;


            int nx= now.x;
            int ny= now.y;
            for(int i=1;i<now.size;i++)
            {

                for(int idx=0;idx<4;idx++)
                {
                    nx= now.x+ dx[idx]*i;
                    ny= now.y+dy[idx]*i;
                    if(isBoundary(nx,ny) && board[nx][ny]>=1)
                    {
                        q.add(new Bomb(nx,ny,board[nx][ny]));
                        answerCnt++;
                    }
                }

            }
        }
    }

    private static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<H && y>=0 && y<W;
    }

}