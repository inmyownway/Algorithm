import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N,M;
    static int[][] board;
    static int minNum;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int homeNum;
    static int maxNum=-1;
    public static void main(String[] args) throws IOException {

        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase= Integer.parseInt(bf.readLine());

        for(int tc=1;tc<testCase+1;tc++)
        {
            st= new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());

            minNum=Integer.MIN_VALUE;
            board= new int[N][N];
            maxNum=-1;

            homeNum=0;
            for(int i=0;i<N;i++) {
                st= new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++)
            {
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]==1)
                {
                    homeNum+=1;
                }
            }
            }

            int k=1;

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                  check(i,j);

                }


            }

            System.out.println("#"+tc+" "+maxNum);
        }


    }
    public static void check(int x,int y)
    {
        boolean[][] visited= new boolean[N][N];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;
        int k=1;
        int sum=0;
        if(board[x][y]==1)
            sum++;

        if(k*k+(k-1)*(k-1) <= sum*M)
        {
            maxNum=Math.max(maxNum,sum);
            
        }        

        k++;

        while(!q.isEmpty())
        {

            int qlen= q.size();


            for(int idx=0;idx<qlen;idx++)
            {

                int[] now =q.poll();



                for(int i=0;i<4;i++)
                {



                    int nx= now[0]+dx[i];
                    int ny= now[1]+dy[i];

                    if(isBoundary(nx,ny) && !visited[nx][ny])
                    {
                        q.add(new int[]{nx,ny});
                        visited[nx][ny]=true;
                        // 집 발견
                        if(board[nx][ny]==1)
                        {
                            sum++;
                        }


                    }

                }



            }

      



         
            if(k*k+(k-1)*(k-1) <= sum*M)
            {
                maxNum=Math.max(maxNum,sum);
            
            }
            k++;

            if(k==N*N)
                break;


        }


    }

    public static boolean isBoundary(int x,int y)
    {
        return x>=0&& x<N && y>=0 && y<N;
    }

}