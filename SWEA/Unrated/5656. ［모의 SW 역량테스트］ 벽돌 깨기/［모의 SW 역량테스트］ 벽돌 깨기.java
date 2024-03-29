import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {


    static int N;
    static int W;
    static int H;
    static int[][] board;
    static int[] num;
    static int[] dx= {0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int answer;
    static int[][] saveBoard;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase= Integer.parseInt(bf.readLine());

        for(int test=1;test<testCase+1;test++)
        {
            st=new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());
            H=Integer.parseInt(st.nextToken());
            board= new int[H][W];
            answer= Integer.MAX_VALUE;
            saveBoard= new int[H][W];
            num= new int[W];
            arr= new int[N];
            for(int i=0;i<H;i++)
            {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<W;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());
                    saveBoard[i][j]=board[i][j];
                }
            }
            for(int i=0;i<W;i++)
            {
                num[i]=i;
            }

            perm(0);
            System.out.println("#"+test+" "+answer);
        }


    }
    public static void perm(int depth)
    {
        if(depth==N)
        {

            Game(arr);
            return;
        }

        for(int i=0;i<W;i++)

        {

            arr[depth]=num[i];
            perm(depth+1);

        }

    }

    private static void Game(int[] number) {
       // System.out.println("구슬(순열돌린거): "+ Arrays.toString(number));


        for(int i=0;i<H;i++)
        {
            for(int j=0;j<W;j++)
            {
                board[i][j]=saveBoard[i][j];
            }
        }


        for (int n : number) {

            for (int x = 0; x < H; x++)
            {
                if (board[x][n]!=0)
                {

                    // System.out.println(x+" "+n);
                    shooting(x,n);
                  //  print(board);
                    break;
                }

            }
            move();

        }
   //   print(board);

        // 슈팅 끝, 남아있는거 확인
        int result=0;
        for(int i=0;i<H;i++)
        {
            for(int j=0;j<W;j++)
            {
                if (board[i][j]>=1)
                    result++;
            }
        }

        //System.out.println("남아있는거: "+result);
        answer=Math.min(answer,result);
    }

    private static void move() {

        for(int i=H-2;i>-1;i--)
        {
            for(int j=0;j<W;j++)
            {
                if (board[i][j]>=1)
                {
                    for(int idx=i;idx<H;idx++)
                    {

                        if(idx==H-1)
                            break;
                        if (board[idx+1][j]==0)
                        {
                            board[idx+1][j]=board[idx][j];
                            board[idx][j]=0;

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

    private static void shooting(int x,int y) {

        int[][] tempBoard=new int[H][W];
        for(int i=0;i<H;i++)
        {
            for(int j=0;j<W;j++)
            {
                tempBoard[i][j]=board[i][j];
            }
        }

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty())
        {

            int s= q.size();

            for(int si=0;si<s;si++)
            {
                int[] now = q.poll();
                int range= board[now[0]][now[1]];
                //(range);
                tempBoard[now[0]][now[1]]=0;

                for(int i=0;i<4;i++)
                {
                    int nx= now[0];
                    int ny= now[1];

                    //  System.out.println("bomb: "+ board[nx][ny]);
                    for(int idx=0;idx<range-1;idx++)
                    {
                        nx+=dx[i];
                        ny+=dy[i];

                        //  System.out.println("nx ny "+nx+" "+ny );
                        if(isBoundary(nx,ny) )
                        {
                            if(tempBoard[nx][ny]>=2)
                            {
                                q.add(new int[]{nx,ny});
                            }

                            tempBoard[nx][ny]=0;

                        }
                    }
                }

            }




        }
        for(int i=0;i<H;i++)
        {
            for(int j=0;j<W;j++)
            {
                board[i][j]=tempBoard[i][j];
            }
        }
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<H && y>=0  && y<W;
    }


    public static void swap(int x,int y)
    {

        int temp= num[x];
        num[x]=num[y];
        num[y]=temp;
    }
    public static void print(int[][] bb)
    {
        for(int[] b :bb)
        {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }

}