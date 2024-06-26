import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, max, min;
    static int[][] board;
    static boolean[][] v;
    static int day;
    static boolean check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] newBoard;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {

            check = false;
            v = new boolean[N][N];
            newBoard = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[i][j]) {
                        //System.out.println("i j" + " " + i + " " + " " + j);
                        bfs(i, j);


                    }
                }
            }

            if (check == false) {
                break;
            }
            //System.out.println(day);
            day++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //   System.out.print(newBoard[i][j] + " ");
                    board[i][j] = newBoard[i][j];
                }
                //  System.out.println();
            }
        }
        System.out.println(day);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        v[x][y] = true;
        ArrayList<int[]> change = new ArrayList<>();
        change.add(new int[]{x, y});
        int allSum = board[x][y];
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int xx = now[0];
            int yy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (isBoundary(nx, ny) && !v[nx][ny]) {
                    int sum = Math.abs(board[xx][yy] - board[nx][ny]);
                    if (sum >= min && sum <= max) {
                        check = true;
                        v[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        change.add(new int[]{nx, ny});
                        allSum += board[nx][ny];
                    }
                }
            }
        }

        // 처리하기

        int num = allSum / change.size();

        for (int[] now : change) {
            newBoard[now[0]][now[1]] = num;
        }

    }

    public static boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}