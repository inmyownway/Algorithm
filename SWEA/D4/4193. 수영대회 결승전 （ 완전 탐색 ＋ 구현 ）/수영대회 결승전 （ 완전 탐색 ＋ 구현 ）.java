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
    static int[][] board;
    static int[] dx= {0,0,-1,1};
    static int[] dy ={1,-1,0,0};
    static boolean[][] v;
    static ArrayList<int[]> tonado;
    static int time;
    static int sx,sy,ex,ey;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int testCase= Integer.parseInt(st.nextToken());
        for(int test=1;test<testCase+1;test++)
        {

            N= Integer.parseInt(bf.readLine());
            board = new int[N][N];
            v= new boolean[N][N];
            answer= 0;

            for(int i=0;i<N;i++)
            {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());

                }
            }

            st= new StringTokenizer(bf.readLine());
            sx= Integer.parseInt(st.nextToken());
            sy= Integer.parseInt(st.nextToken());

            st= new StringTokenizer(bf.readLine());
            ex= Integer.parseInt(st.nextToken());
            ey= Integer.parseInt(st.nextToken());

            if(sx==ex && sy==ey)
            {
                System.out.println("#"+test+" "+0);
                continue;
            }
            bfs();
            if(answer==0)
                answer=-1;
            System.out.println("#"+test+" "+answer);

        }


    }
    private static void bfs()
    {
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{sx,sy,1});
        v[sx][sy]=true;

        while(!q.isEmpty())
        {
            time++;


                int[] now = q.poll();
              //  System.out.println(Arrays.toString(now) +" "+time);
                for(int idx=0;idx<4;idx++)
                {

                    int nx= now[0]+dx[idx];
                    int ny= now[1]+dy[idx];
                    if(!isBoundary(nx,ny)) continue;
                    if(nx==ex && ny==ey)
                    {
                        answer=now[2];
                        return;

                    }
                    if(v[nx][ny] || board[nx][ny]==1) continue;



                   if(board[nx][ny]==2)
                   {
                       if(now[2]%3==0)
                       {
                           v[nx][ny]=true;
                           q.add(new int[]{nx,ny,now[2]+1});
                       }
                       else
                       {
                           v[now[0]][now[1]]=true;
                           q.add(new int[]{now[0],now[1],now[2]+1});
                       }
                   }
                   else
                   {
                       v[nx][ny]=true;
                       q.add(new int[]{nx,ny,now[2]+1});
                   }
                }
            }

    }

    private static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;

    }


    public static void bfs2()
    {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {sx,sy,0});
        v[sx][sy]=true;



        while(!q.isEmpty())
        {
            int[] now = q.poll();

            int x=now[0];
            int y=now[1];
            int cnt=now[2];


            for(int i=0;i<4;i++)
            {

                int nx=x+dx[i];
                int ny=y+dy[i];




                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(nx==ex && ny==ey)
                {
                    answer= cnt+1;
                    return;

                }


                if(v[nx][ny]==true || board[nx][ny]==1) continue;

                if(board[nx][ny]==2)
                {

                    if(cnt%3 == 0)
                    {
                        v[nx][ny] = true;
                        q.add(new int[] {nx,ny,cnt+1});
                    }
                    else
                    {
                        v[x][y] = true;
                        q.add(new int[] {x,y,cnt+1});
                    }

                }
                else
                {
                    v[nx][ny]=true;
                    q.add(new int[] {nx,ny,cnt+1});

                }




            }


        }

    }
}