import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static class Node implements Comparable<Node> {
        int x, y, mirrorCnt, dir;
        
        public Node(int x, int y, int mirrorCnt, int dir) {
            this.x = x;
            this.y = y;
            this.mirrorCnt = mirrorCnt;
            this.dir = dir;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.mirrorCnt - o.mirrorCnt;
        }
    }
    
    static char[][] board;
    static int[][][] dist;
    static int sx, sy, ex, ey;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        board = new char[H][W];
        dist = new int[H][W][4];
        
        boolean found = false;
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'C') {
                    if (!found) {
                        sx = i;
                        sy = j;
                        found = true;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
                for (int k = 0; k < 4; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        bfs();
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dist[ex][ey][i]);
        }
        
        System.out.println(answer);
    }
    
    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if (isInBounds(nx, ny) && board[nx][ny] != '*') {
                pq.offer(new Node(nx, ny, 0, i));
                dist[nx][ny][i] = 0;
            }
        }
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            
            if (node.x == ex && node.y == ey) return;
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int newMirrors = node.mirrorCnt + (node.dir != i ? 1 : 0);
                
                if (isInBounds(nx, ny) && board[nx][ny] != '*' && dist[nx][ny][i] > newMirrors) {
                    dist[nx][ny][i] = newMirrors;
                    pq.offer(new Node(nx, ny, newMirrors, i));
                }
            }
        }
    }
    
    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}