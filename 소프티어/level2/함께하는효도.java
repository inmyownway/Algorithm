import java.io.*;
import java.util.*;

public class mm {
    static int N, M;
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Person> person;
    // static int answer = Integer.MIN_VALUE;

    static class Person {
        int x;
        int y;

        Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        person = new ArrayList<>();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {

                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            person.add(new Person(x - 1, y - 1));

            sum += board[x - 1][y - 1];
            // System.out.println(x + " " + y);
            board[x - 1][y - 1] = 0;
        }
        // System.out.println("sum " + sum);

        int idx = 0;

        Person p = person.get(0);

        int[] answer = new int[1];

        bfs(p.x, p.y, sum, 0, 0, answer);
        System.out.println(answer[0]);

    }

    public static void bfs(int x, int y, int sum, int idx, int cnt, int[] answer) {

        answer[0] = Math.max(sum, answer[0]);

        if (cnt == 3) {
            if (idx + 1 < M) {
                Person p = person.get(idx + 1);
                bfs(p.x, p.y, sum, idx + 1, 0, answer);

            }
            
        } else {

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isBoundary(nx, ny)) {

                    int value = board[nx][ny];
                    board[nx][ny] = 0;
                    bfs(nx, ny, sum + value, idx, cnt + 1, answer);
                    board[nx][ny] = value;
                }


            }
        }
    }


    public static boolean isBoundary(int x, int y) {

        return x >= 0 && x < N && y >= 0 && y < N;
    }

}
