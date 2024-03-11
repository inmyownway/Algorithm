import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;




public class Main {

    static int N,M,K;

    static int[] dx= {-1,-1,0,1,1,1,0,-1};
    static int[] dy= {0,1,1,1,0,-1,-1,-1};
    static ArrayList<Ball>[][] map;
    static ArrayList<Ball> ball = new ArrayList<>();
    public static class Ball
    {
        int x;
        int y;
        int m;
        int s;
        int d;
        public Ball(int x, int y, int m, int s, int d) {
            super();
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;

        }


    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(bf.readLine());



        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];


        for(int i=0;i<M;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int r= Integer.parseInt(st.nextToken())-1;
            int c= Integer.parseInt(st.nextToken())-1;
            int m= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());
            ball.add(new Ball(r,c,m,s,d));
        }

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[i][j]=new ArrayList<>();
            }
        }


        for(int i=0;i<K;i++){
            move();
            fire();
        }
        int answer=0;
        for(Ball b : ball)
        {
            answer+=b.m;

        }
        System.out.println(answer);
    }

    public static void move()
    {

        for(Ball cur : ball)
        {
            int tempR = (cur.x + N + dx[cur.d] * (cur.s%N)) % N;
            int tempC = (cur.y + N + dy[cur.d] * (cur.s%N)) % N;
            cur.x = tempR;
            cur.y = tempC;
            //이동한 파이어볼 저장
            map[cur.x][cur.y].add(cur);
        }


    }
    public static void fire()
    {
        for(int r=0;r<N;r++)
        {
            for(int c=0;c<N;c++)
            {
                if(map[r][c].size()<2)
                {
                    map[r][c].clear();
                    continue;
                }

                int mSum=0;
                int sSum=0;
                int oddCount=0;
                int evenCount=0;

                int size=map[r][c].size();

                for(Ball cur: map[r][c])
                {
                    mSum+=cur.m;
                    sSum+=cur.s;

                    if(cur.d%2==1)
                        oddCount++;
                    else
                        evenCount++;
                    ball.remove(cur);
                }

                map[r][c].clear();
                mSum/=5;

                if(mSum==0)
                    continue;
                sSum/=size;

                if(oddCount == size || evenCount == size){
                    for(int i=0;i<8;i+=2)
                        ball.add(new Ball(r,c,mSum, sSum, i));
                }else{
                    for(int i=1;i<8;i+=2)
                        ball.add(new Ball(r,c,mSum, sSum, i));
                }

            }
        }
    }

    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }
    public static void print()
    {
        for(Ball b: ball)
        {
            System.out.println(b);
        }
        System.out.println();
    }

}