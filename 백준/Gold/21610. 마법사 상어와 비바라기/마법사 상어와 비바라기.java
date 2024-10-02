import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] command;
    static boolean[][] v;
    static int[] ex = {1, 1, -1, -1};
    static int[] ey = {1, -1, 1, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        command = new int[M][2];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            command[i][0] = a;
            command[i][1] = b;

            //System.out.println(Arrays.toString(command[i]));
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N - 1, 0});
        q.add(new int[]{N - 1, 1});
        q.add(new int[]{N - 2, 0});
        q.add(new int[]{N - 2, 1});

        for (int i = 0; i < M; i++) {
            //System.out.println("i@@@@@@@@@@@@@@@ " + i);
            v = new boolean[N][N];

            int d = command[i][0];
            int s = command[i][1];
            //ystem.out.println(d);
            int size = q.size();

            for (int ss = 0; ss < size; ss++) {
                //System.out.println(ss);import java.io.*;
                //import java.util.*;
                //
                //public class BOJ_마법사상어와비바라기 {
                //    static int N, M;
                //    static int[][] board;
                //    static int[][] command;
                //    static boolean[][] v;
                //    static int[] ex = {1, 1, -1, -1};
                //    static int[] ey = {1, -1, 1, -1};
                //    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
                //    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
                //
                //    public static void main(String[] args) throws IOException {
                //
                //        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                //        StringTokenizer st = new StringTokenizer(bf.readLine());
                //
                //        N = Integer.parseInt(st.nextToken());
                //        M = Integer.parseInt(st.nextToken());
                //
                //        board = new int[N][N];
                //        command = new int[M][2];
                //        v = new boolean[N][N];
                //        for (int i = 0; i < N; i++) {
                //            st = new StringTokenizer(bf.readLine());
                //            for (int j = 0; j < N; j++) {
                //                board[i][j] = Integer.parseInt(st.nextToken());
                //            }
                //        }
                //        for (int i = 0; i < M; i++) {
                //            st = new StringTokenizer(bf.readLine());
                //
                //            int a = Integer.parseInt(st.nextToken());
                //            int b = Integer.parseInt(st.nextToken());
                //
                //            command[i][0] = a;
                //            command[i][1] = b;
                //
                //            //System.out.println(Arrays.toString(command[i]));
                //        }
                //
                //        Queue<int[]> q = new LinkedList<>();
                //        q.add(new int[]{N - 1, 0});
                //        q.add(new int[]{N - 1, 1});
                //        q.add(new int[]{N - 2, 0});
                //        q.add(new int[]{N - 2, 1});
                //
                //        for (int i = 0; i < M; i++) {
                //            //System.out.println("i@@@@@@@@@@@@@@@ " + i);
                //            v = new boolean[N][N];
                //
                //            int d = command[i][0];
                //            int s = command[i][1];
                //            //ystem.out.println(d);
                //            int size = q.size();
                //
                //            for (int ss = 0; ss < size; ss++) {
                //                //System.out.println(ss);
                //                int[] now = q.poll();
                //
                //                int x = now[0];
                //                int y = now[1];
                //                // int x = now[0] + (dx[d - 1] * s);
                //                //int y = now[1] + (dy[d - 1] * s);
                //
                //                // System.out.println(Arrays.toString(now));
                //                // System.out.println(x + " " + y);
                //                now = move(x, y, d, s);
                //                //System.out.println(Arrays.toString(now));
                //                x = now[0];
                //                y = now[1];
                //
                //                board[x][y] += 1;
                //                v[x][y] = true;
                //
                //            }
                //            int[][] temp = new int[N][N];
                //
                //            for (int a = 0; a < N; a++) {
                //                for (int b = 0; b < N; b++) {
                //                    int cnt = 0;
                //
                //                    if (v[a][b]) {
                //                        for (int idx = 0; idx < 4; idx++) {
                //                            int nx = a + ex[idx];
                //                            int ny = b + ey[idx];
                //                            if (isBoundary(nx, ny) && board[nx][ny] >= 1) {
                //                                cnt++;
                //                            }
                //                        }
                //                        // System.out.println(a + " " + b + " " + temp[a][b]);
                //                        temp[a][b] = cnt;
                //                    }
                //
                //                }
                //            }
                //
                //            for (int a = 0; a < N; a++) {
                //                for (int b = 0; b < N; b++) {
                //                    board[a][b] += temp[a][b];
                //
                //                }
                //            }
                //
                //            for (int a = 0; a < N; a++) {
                //                for (int b = 0; b < N; b++) {
                //
                //                    if (board[a][b] >= 2 && v[a][b] == false) {
                //                        q.add(new int[]{a, b});
                //                        // System.out.println(a + " " + b);
                //                        board[a][b] -= 2;
                //                    }
                //                }
                //            }
                //
                //        }
                //        int cnt = 0;
                //        for (int a = 0; a < N; a++) {
                //            for (int b = 0; b < N; b++) {
                //
                //                cnt += board[a][b];
                //            }
                //        }
                //        System.out.println(cnt);
                //    }
                //
                //    public static boolean isBoundary(int x, int y) {
                //        return x >= 0 && x < N && y >= 0 && y < N;
                //    }
                //
                //    public static int[] move(int x, int y, int d, int s) {
                //
                //        for (int idx = 0; idx < s; idx++) {
                //            x += dx[d - 1];
                //            y += dy[d - 1];
                //            if (x < 0) {
                //                x = N - 1;
                //            } else if (x >= N) {
                //                x = 0;
                //            }
                //            if (y < 0) {
                //                y = N - 1;
                //            } else if (y >= N) {
                //                y = 0;
                //            }
                //
                //        }
                //        return new int[]{x, y};
                //
                //    }
                //}
                int[] now = q.poll();

                int x = now[0];
                int y = now[1];
                // int x = now[0] + (dx[d - 1] * s);
                //int y = now[1] + (dy[d - 1] * s);

                // System.out.println(Arrays.toString(now));
                // System.out.println(x + " " + y);
                now = move(x, y, d, s);
                //System.out.println(Arrays.toString(now));
                x = now[0];
                y = now[1];

                board[x][y] += 1;
                v[x][y] = true;

            }
            int[][] temp = new int[N][N];

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    int cnt = 0;

                    if (v[a][b]) {
                        for (int idx = 0; idx < 4; idx++) {
                            int nx = a + ex[idx];
                            int ny = b + ey[idx];
                            if (isBoundary(nx, ny) && board[nx][ny] >= 1) {
                                cnt++;
                            }
                        }
                        // System.out.println(a + " " + b + " " + temp[a][b]);
                        temp[a][b] = cnt;
                    }

                }
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    board[a][b] += temp[a][b];

                }
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {

                    if (board[a][b] >= 2 && v[a][b] == false) {
                        q.add(new int[]{a, b});
                        // System.out.println(a + " " + b);
                        board[a][b] -= 2;
                    }
                }
            }

        }
        int cnt = 0;
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {

                cnt += board[a][b];
            }
        }
        System.out.println(cnt);
    }

    public static boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int[] move(int x, int y, int d, int s) {

        x = (x + dx[d - 1] * s) % N;
        y = (y + dy[d - 1] * s) % N;

        if (x < 0) {
            x += N;
        }
        if (y < 0) {
            y += N;
        }

        return new int[]{x, y};

    }
}