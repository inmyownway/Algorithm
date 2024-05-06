import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N,M,C;
    static int[][] board;
    static boolean[][] v;
    static boolean[] visited;
    static int sum,answer;
    static int[] nums;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase= Integer.parseInt(bf.readLine());

        for(int test=1;test<testCase+1;test++) {

            st= new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            board= new int[N][N];
        result=0;
            answer=Integer.MIN_VALUE;

            for(int i=0;i<N;i++)
            {
                st=new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());
                }
            }


            for(int i=0;i<N;i++)
            {
                for(int j=0;j<=N-M;j++)
                {
                    // first
                  //  System.out.println("ij "+ i+" "+j);
                    v= new boolean[N][N];
                    sum=0;
                    visited= new boolean[M];
                    first(i,j);
                    answer=sum;
                 //   System.out.println("!"+answer);
                    for(int a=0;a<N;a++)
                    {
                        for(int b=0;b<=N-M;b++)
                        {
                            sum=0;
                           // System.out.println("@");
                            boolean flag= true;
                          // System.out.println(a+" "+b);

                            for(int idx=0;idx<M;idx++)
                            {
                                if(v[a][b+idx])
                                {
                                    flag=false;
                                    break;
                                }
                            }

                            if(flag)
                            {
                                second(a,b);

                                result=Math.max(result,answer+sum);
                            }

                        }
                    }

                }
            }
            System.out.println("#"+test+" "+result);
        }
    }
    private static void second(int x,int y)
    {
        nums= new int[M];

        for(int i=0;i<M;i++)
        {

            nums[i]=board[x][y+i];


        }
        subset(0);
    }

    private static void first(int x,int y)
    {
        nums= new int[M];

        for(int i=0;i<M;i++)
        {

            nums[i]=board[x][y+i];
            v[x][y+i]=true;

        }
        subset(0);
    }

    private static void subset(int depth)
    {
        if(depth==M)
        {

            int num=0;
            for(int i=0;i<M;i++)
            {
                if(visited[i])//[i])
                {
                    num += nums[i];
                }

            }
            if(num<=C)
            {
                int s=0;
                for(int i=0;i<M;i++)
                {
                    if(visited[i])
                        s+= nums[i]*nums[i];
                }
                sum=Math.max(s,sum);
            }
            return;
        }

        visited[depth]=true;
        subset(depth+1);
        visited[depth]=false;
        subset(depth+1);

    }

}