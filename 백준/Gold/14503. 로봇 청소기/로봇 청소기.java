import java.util.Scanner;

public class Main {
    static int N, M;
    static int x, y, d;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        d = sc.nextInt();

        board = new int[N][M];
        visited = new boolean[N][M];
        visited[x][y] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        while (true) {
            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                d = (d - 1 + 4) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && board[nx][ny] == 0) {
                        flag = true;
                        x = nx;
                        y = ny;
                        visited[x][y] = true;
                        break;
                    }
                }
            }

            if (!flag) {
                int backX = x - dx[d];
                int backY = y - dy[d];

                if (backX < 0 || backX >= N || backY < 0 || backY >= M || board[backX][backY] == 1) {
                    break;
                } else {
                    x = backX;
                    y = backY;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}