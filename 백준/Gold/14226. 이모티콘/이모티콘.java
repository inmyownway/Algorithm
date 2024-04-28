import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int answer= Integer.MAX_VALUE;
    static boolean[][] v;
    static class Emoticon{
        int clipBoard=0;
        int screen=0;
        int time=0;

        public Emoticon(int clipBoard, int screen, int time) {
            this.clipBoard = clipBoard;
            this.screen = screen;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

    N= Integer.parseInt(st.nextToken());
        v= new boolean[1001][1001];
        simulation();
    }

    private static void simulation() {

        Queue<Emoticon> q = new LinkedList();
        q.add(new Emoticon(0,1,0));
        v[0][1]=true;

        while(!q.isEmpty())
        {
            Emoticon now= q.poll();

            if(now.screen==N)
            {
                System.out.println(now.time);
                return;
            }

            // copy
            q.add(new Emoticon(now.screen,now.screen,now.time+1));

            // paste
            if(now.clipBoard!=0 && now.clipBoard+now.screen<=N && v[now.clipBoard][now.clipBoard+now.screen]==false)
            {
                q.add(new Emoticon(now.clipBoard, now.screen+now.clipBoard,now.time+1));
                v[now.clipBoard][now.screen+now.clipBoard]=true;
            }

            // -1
            if(now.screen>=1 && v[now.clipBoard][now.screen-1]==false)
            {
                q.add(new Emoticon(now.clipBoard, now.screen-1,now.time+1));
                        v[now.clipBoard][now.screen-1]=true;
            }
        }
    }

}