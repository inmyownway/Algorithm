import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static List<Virus> viruses = new ArrayList<>();
    static Virus[] active;
    static int originEmptySpace;
    static int maxScore = Integer.MAX_VALUE;

    static class Virus
    {

        int x,y,time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr= new int[N][N];
    active = new Virus[M];

        for(int i=0;i<N;i++)
        {
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++)
            {
                arr[i][j]=Integer.parseInt(st.nextToken());

                if(arr[i][j]==0)
                {
                    originEmptySpace++;
                }
                else if(arr[i][j]==2)
                {
                    viruses.add(new Virus(i,j,0));
                }
            }
        }

      if(originEmptySpace==0)
      {
          System.out.println(0);
      }
      else
      {
          dfs(0,0);

          if(maxScore==Integer.MAX_VALUE)
          {
              System.out.println(-1);
          }
          else
          {
              System.out.println(maxScore);
          }
      }
    }

    static void dfs(int start,int cnt) {

        if(cnt==M)
        {
            spread(originEmptySpace);
            return;
        }
        for(int i=start;i<viruses.size();i++)
        {
            active[cnt]=viruses.get(i);
            dfs(i+1,cnt+1);
        }
    }
    static void spread(int emptySpace)
    {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visited= new boolean[N][N];

        for(int i=0;i<M;i++)
        {
            Virus virus= active[i];

            visited[virus.x][virus.y]=true;
            q.add(virus);
        }

        while(!q.isEmpty())
        {
            Virus virus = q.poll();

            for(int i=0;i<4;i++)
            {
                int nx=virus.x+dx[i];
                int ny= virus.y+dy[i];

                if(!isBoundary(nx,ny)) continue;
                if(visited[nx][ny] || arr[nx][ny]==1) continue;

                if(arr[nx][ny]==0)
                    emptySpace--;

                if(emptySpace==0)
                {
                    maxScore = Math.min(maxScore,virus.time+1);
                    return;
                }

                visited[nx][ny]=true;
                q.add(new Virus(nx,ny, virus.time+1));
            }
        }
    }

    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;

    }


}