import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,H,D;
    static int sx,sy;
    static int ex,ey;
    static int answer;
    static int[] dx ={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int idx=0;
    static char[][] board;
    static int[][] v;

    static class Person{
        int x;
        int y;
        int personLife;
        int umbLife;

        public Person(int x, int y, int personLife, int umbLife) {
            this.x = x;
            this.y = y;
            this.personLife = personLife;
            this.umbLife = umbLife;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        answer= Integer.MAX_VALUE;


    board= new char[N][N];
    v= new int[N][N];
        // input
        for (int i = 0; i < N; i++)
        {
            String str= bf.readLine();
            for(int j=0;j<str.length();j++)
            {
                char c= str.charAt(j);
                if(c=='S')
                {
                    sx= i;
                    sy= j;

                }
                else if(c=='E')
                {
                    ex=i;
                    ey=j;
                }
                else if(c=='U')
                {
                        board[i][j]='U';
                }
            }
        }


        bfs();

;
        if(answer==Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
            System.out.println(answer);
    }


   public static void bfs()
   {
       Queue<Person> q = new LinkedList<>();
       q.add(new Person(sx,sy,H,0));

       v[sx][sy]=H;

       int cnt=0;
       while(!q.isEmpty())
       {
        int size= q.size();
        for(int s=0;s<size;s++)
        {
            Person p = q.poll();

            for(int i=0;i<4;i++)
            {
                int nx = p.x+dx[i];
                int ny= p.y+dy[i];

                if(!isBoundary(nx,ny))
                    continue;


                int nowPersonLife= p.personLife;
                int nowUmbLife= p.umbLife;

                if(nx== ex && ny ==ey)
                {
                    answer=cnt+1;
                    return;
                }

                if(board[nx][ny]=='U')
                    nowUmbLife=D;

                if(nowUmbLife!=0)
                {
                    nowUmbLife--;
                }
                else
                {
                    nowPersonLife--;
                }
                if(nowPersonLife==0)
                    continue;

                if(v[nx][ny] < nowPersonLife+nowUmbLife)
                {
                    v[nx][ny]=nowPersonLife+nowUmbLife;
                    q.add(new Person(nx,ny,nowPersonLife,nowUmbLife));
                }
            }
        }cnt++;

       }
   }


    private static boolean isBoundary(int x,int y)
    {
        return  x>=0 && x<N && y>=0 && y<N;
    }
}