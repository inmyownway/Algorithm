import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] board;
    static boolean[][] isClean;
    static int x, y, d;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        isClean = new boolean[N][M];
        int answer = 0;
        st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    isClean[i][j] = true;
                }
            }
        }
        int c = 0;
        while (true) {
            //  System.out.println(x + " " + y);
            if (!isClean[x][y]) {
                isClean[x][y] = true;

            }

            if (allCheck(x, y)) {
                if (d == 0) {
                    x += 1;
                } else if (d == 1) {
                    y -= 1;
                } else if (d == 2) {
                    x -= 1;
                } else if (d == 3) {
                    y += 1;
                }

                if (!isBoundary(x, y)) {
                    break;
                }
                if (board[x][y] == 1) {
                    break;
                }
                continue;
            } else {

                d -= 1;
                if (d < 0) {
                    d = 3;
                }

                if (isBoundary(x + dx[d], y + dy[d]) && !isClean[x + dx[d]][y + dy[d]]
                        && board[x + dx[d]][y + dy[d]] != 1) {
                    x += dx[d];
                    y += dy[d];
                }
            }
            c++;
//            if (c == 10) {
//                break;
//            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isClean[i][j] && board[i][j] == 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);


    }

    public static boolean allCheck(int x, int y) {
        int cnt = 0;
        for (int idx = 0; idx < 4; idx++) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (isBoundary(nx, ny) && isClean[nx][ny] == false && board[nx][ny] == 0) {
                cnt++;
            }
        }

        if (cnt >= 1) {
            return false;
        }
        return true;

    }

    public static boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}