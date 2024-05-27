import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L,R,C;
    static char[][][] board;
    static boolean[][][] v;
    static int sl,sx,sy;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int[] ux={1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(
                true
        )
        {

            st= new StringTokenizer(bf.readLine());

            L= Integer.parseInt(st.nextToken());
            R= Integer.parseInt(st.nextToken());
            C= Integer.parseInt(st.nextToken());

            if(L==0 && R==0 && C==0)
            {
                return;
            }

            board= new char[L][R][C];

            for(int idx=0;idx<L;idx++)
            {
             //   System.out.println(idx);s
                //System.out.println(idx);
                for(int i=0;i<R;i++)
                {
                    String str= bf.readLine();
                    for(int j=0;j<C;j++)
                    {
                        if(str.charAt(j)=='S')
                        {
                            sl=idx;
                            sx=i;
                            sy=j;
                           // System.out.println(sx+" "+sy);
                        }
                        board[idx][i][j]=str.charAt(j);
                    }
                }

                bf.readLine();
            }


            bfs();

        }

    }
    public static void bfs()
    {
        v=new boolean[L][R][C];

        Queue<int[]> q= new LinkedList<>();

        q.add(new int[]{sl,sx,sy,0});
    v[sl][sx][sy]=true;
        while(!q.isEmpty())
        {
            int[] now = q.poll();
            //System.out.println(Arrays.toString(now));

            int l=now[0];
            int r=now[1];
            int c=now[2];
            int cnt= now[3];

            if(board[l][r][c]=='E')
            {
                System.out.println("Escaped in "+cnt+" minute(s).");


                return;
            }

            // 상하좌우
            for(int idx=0;idx<4;idx++)
            {
                int nr = r+dx[idx];
                int nc = c+dy[idx];
                if(isBoundary(l,nr,nc) && v[l][nr][nc]==false && board[l][nr][nc]!='#')
                {
                    v[l][nr][nc]=true;
                    q.add(new int[]{l,nr,nc,cnt+1});
                }
            }
            for(int idx=0;idx<2;idx++)
            {
                int nl = l+ux[idx];
                if(isBoundary(nl,r,c) && v[nl][r][c]==false && board[nl][r][c]!='#')
                {
                    v[nl][r][c]=true;
                    q.add(new int[]{nl,r,c,cnt+1});
                }
            }

        }
        System.out.println("Trapped!");
    }

    private static boolean isBoundary(int l,int x,int y)
    {
        return l>=0 & l<L &&  x>=0 && x<R && y>=0 && y<C;
    }
}