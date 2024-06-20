import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][] v;
    static boolean[][][] ice;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static class Wolf {
        int x;
        int y;
        int d;

        public Wolf(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static Queue<Wolf> q;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N][M];
        board = new char[N][M];
        ice = new boolean[N][M][4];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'W') {
                    q.add(new Wolf(i, j, -1));
                    v[i][j] = true;
                } else if (board[i][j] == '#') {
                    v[i][j] = true;
                }
            }
        }

        start();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j] && board[i][j] != '+') {
                    board[i][j] = 'P';
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }


    }

    public static void start() {
        while (!q.isEmpty()) {

            //int size = q.size();
            Wolf now = q.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nx = now.x + dx[idx];
                int ny = now.y + dy[idx];
                int dir = now.d;

                if (isBoundary(nx, ny)) {
                    if (board[nx][ny] == '.') {

                        if (!v[nx][ny]) {
                            v[nx][ny] = true;
                            q.add(new Wolf(nx, ny, -1));
                        }
                    } else if (board[nx][ny] == '+' && !ice[nx][ny][idx]) {
                        // 빙판길 미끄러지기
                        v[nx][ny] = true;
                        ice[nx][ny][idx] = true;

                        int tx = nx;
                        int ty = ny;

                        while (true) {
                            if (board[tx][ty] == '#') {

                                q.add(new Wolf(tx - dx[idx], ty - dy[idx], -1));
                                break;

                            } else if (board[tx][ty] == '.') {
                                q.add(new Wolf(tx, ty, -1));
                                break;
                            }
                            tx += dx[idx];
                            ty += dy[idx];
                            ice[nx][ny][idx] = true;

                            v[tx][ty] = true;

                        }

                        v[tx][ty] = true;
                        ice[nx][ny][idx] = true;

                    }
                }
            }


        }
    }

    public static boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}