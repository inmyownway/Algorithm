import java.util.*;
import java.io.*;

public class Main {
    static int sx, sy, kx, ky;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt = Integer.MAX_VALUE;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        kx = Integer.parseInt(st.nextToken());

        ky = Integer.parseInt(st.nextToken());
        v = new boolean[10][9];
        v[sx][sy] = true;
        dfs(sx, sy, 0);
        System.out.println(cnt);

    }

    public static void dfs(int x, int y, int c) {
        if (c >= cnt) {
            return;
        }
        //System.out.println(x + " " + y);
        if (x == kx && y == ky) {
            cnt = Math.min(cnt, c);
            return;
        }

        for (int idx = 0; idx < 4; idx++) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            // 오른쪽으로가는경우
            if (idx == 0) {
                // (-1,1)
                if (checkPos(nx - 1, ny + 1) && isBoundary(nx - 2, ny + 2) && !v[nx - 2][ny + 2]) {
                    v[nx - 2][ny + 2] = true;
                    dfs(nx - 2, ny + 2, c + 1);
                    v[nx - 2][ny + 2] = false;

                }

                if (checkPos(nx + 1, ny + 1) && isBoundary(nx + 2, ny + 2) && !v[nx + 2][ny + 2]) {
                    v[nx + 2][ny + 2] = true;

                    dfs(nx + 2, ny + 2, c + 1);
                    v[nx + 2][ny + 2] = false;

                }
            } else if (idx == 1) {
                if (checkPos(nx - 1, ny - 1) && isBoundary(nx - 2, ny - 2) && !v[nx - 2][ny - 2]) {
                    v[nx - 2][ny - 2] = true;

                    dfs(nx - 2, ny - 2, c + 1);
                    v[nx - 2][ny - 2] = false;

                }

                if (checkPos(nx + 1, ny - 1) && isBoundary(nx + 2, ny - 2) && !v[nx + 2][ny - 2]) {
                    v[nx + 2][ny - 2] = true;

                    dfs(nx + 2, ny - 2, c + 1);
                    v[nx + 2][ny - 2] = false;

                }
            } else if (idx == 2) // 위로
            {
                if (checkPos(nx - 1, ny - 1) && isBoundary(nx - 2, ny - 2) && !v[nx - 2][ny - 2]) {
                    v[nx - 2][ny - 2] = true;

                    dfs(nx - 2, ny - 2, c + 1);
                    v[nx - 2][ny - 2] = false;

                }

                if (checkPos(nx - 1, ny + 1) && isBoundary(nx - 2, ny + 2) && !v[nx - 2][ny + 2]) {
                    v[nx - 2][ny + 2] = true;

                    dfs(nx - 2, ny + 2, c + 1);
                    v[nx - 2][ny + 2] = false;

                }
            } else  // 위로
            {
                if (checkPos(nx + 1, ny - 1) && isBoundary(nx + 2, ny - 2) && !v[nx + 2][ny - 2]) {
                    v[nx + 2][ny - 2] = true;

                    dfs(nx + 2, ny - 2, c + 1);
                    v[nx + 2][ny - 2] = false;

                }

                if (checkPos(nx + 1, ny + 1) && isBoundary(nx + 2, ny + 2) && !v[nx + 2][ny + 2]) {
                    v[nx + 2][ny + 2] = true;

                    dfs(nx + 2, ny + 2, c + 1);
                    v[nx + 2][ny + 2] = false;

                }
            }
        }

    }

    public static boolean checkPos(int x, int y) {
        if (x == kx && y == ky) {
            return false;
        }
        return true;
    }

    public static boolean isBoundary(int rx, int ry) {
        return rx >= 0 && rx <= 9 && ry >= 0 && ry <= 8;

    }
}