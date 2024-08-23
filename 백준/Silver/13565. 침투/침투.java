import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] v;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();

            // System.out.println(str);
            for (int j = 0; j < M; j++) {
                //   System.out.println(j);
                board[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            if (board[0][i] == 0) {
                q.add(new int[]{0, i});
                v[0][i] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];

            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (isBoundary(nx, ny) && !v[nx][ny] && board[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    v[nx][ny] = true;
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i < M; i++) {

            if (board[N - 1][i] == 0 && v[N - 1][i] == true) {
                flag = true;
            }

        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");

        }
    }

    public static boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}