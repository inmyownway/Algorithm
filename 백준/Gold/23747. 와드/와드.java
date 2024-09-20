import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[] command;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            String str = bf.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }

        }
        int sx = 0;
        int sy = 0;

        st = new StringTokenizer(bf.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;

        String c = bf.readLine();
        command = new char[c.length()];
        for (int i = 0; i < c.length(); i++) {
            command[i] = c.charAt(i);
        }

        for (char com : command) {
            if (com == 'U') {
                sx -= 1;
            } else if (com == 'D') {
                sx += 1;
            } else if (com == 'L') {
                sy -= 1;
            } else if (com == 'R') {
                sy += 1;
            } else if(com=='W'){
                if (!v[sx][sy]) {
                    installWard(sx, sy);
                }
            }

        }

        v[sx][sy] = true;
        for (int idx = 0; idx < 4; idx++) {
            int nx = sx + dx[idx];
            int ny = sy + dy[idx];
            if (isBoundary(nx, ny)) {
                v[nx][ny] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (v[i][j]) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void installWard(int x, int y) {
        char current = board[x][y];

        v[x][y] = true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nx = now[0] + dx[idx];
                int ny = now[1] + dy[idx];

                if (isBoundary(nx, ny) && board[nx][ny] == current && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}