import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;





public class Solution {

    static int N;
    // 상 하 좌 우
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int answer;


    static int[][] map = new int[4001][4001];
    static Queue<Atom> q;
    public static class Atom
    {
        int x;
        int y;
        int d;
        int power;

        public Atom(int y, int x, int d, int power) {
            super();
            this.x = x;
            this.y = y;
            this.d = d;

            this.power = power;
        }
        @Override
        public String toString() {
            return "atom [x=" + x + ", y=" + y + ", d=" + d + ", power=" + power ;
        }

    }
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase= Integer.parseInt(st.nextToken());

        for(int tc=1;tc<testCase+1;tc++)
        {

            N= Integer.parseInt(bf.readLine());

            answer=0;
            q= new LinkedList<>();

            for(int i=0;i<N;i++)
            {
                st= new StringTokenizer(bf.readLine());

                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                int d= Integer.parseInt(st.nextToken());
                int power =Integer.parseInt(st.nextToken());
                if (power==0) power=101;
                q.add(new Atom(2*y+2000,2*x+2000,d,power));
            }
            bfs();
            System.out.println("#"+tc+" "+answer);
        }



    }
    public static void bfs()
    {

        // TODO Auto-generated method stub
        int cntzero = 0;
        // map을 테케마다 선언   안해줘도 되는게 범위를 벗어나게되면 map현재값이 0으로 바뀐다.
        while(!q.isEmpty()) {
            Atom cur = q.poll();

            // 현재 위치에서 값이 내 에너지보다 크면
            if(map[cur.y][cur.x]>cur.power) {
                if(cur.power==101) {
                    cntzero++;
                }
                answer += map[cur.y][cur.x];
                map[cur.y][cur.x]=0;
                continue;
            }

            // 현재위치를 0으로 만들기
            map[cur.y][cur.x]=0;
            int ny = cur.y + dy[cur.d];
            int nx = cur.x + dx[cur.d];
            if(0>nx || nx>4000 || 0>ny|| ny>4000) continue;
            // map[ny][nx]가 0일 경우
            if(map[ny][nx]==0) {
                q.offer(new Atom(ny,nx,cur.d,cur.power));
            }
            // 아닐 경우 queue에 넣어줄 필요 없고 energy가 0인지 확
            else {
                if(cur.power==101) {
                    cntzero++;
                }
            }

            map[ny][nx] += cur.power;
        }
        answer -= cntzero*101;
    }

}