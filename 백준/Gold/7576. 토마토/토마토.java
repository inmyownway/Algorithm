import java.util.*;

public class Main {
    static int m, n;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        graph = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        bfs(q);

        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, graph[i][j]);
            }
        }
        System.out.println(day - 1);
    }

    public static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}