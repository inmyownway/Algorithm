import java.util.*;
import java.io.*;

public class Main {
    static int A, B;
    static int N, M;
    static int[][] bus;
    static int[] v;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(bf.readLine()); // 버스의 개수

        bus = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(bus[i], -1);
        }

        v = new int[N];
        Arrays.fill(v, Integer.MAX_VALUE); // 초기값을 MAX_VALUE로 설정

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (bus[a - 1][b - 1] == -1 || bus[a - 1][b - 1] > c) {
                bus[a - 1][b - 1] = c; // 중복된 입력이 있을 경우 더 작은 비용으로 업데이트
            }
        }

        st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;

        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { A, 0 });
        v[A] = 0; // 시작점의 비용은 0으로 설정

        while (!q.isEmpty()) {
            int[] n = q.poll();

            int idx = n[0];
            int cnt = n[1];

            if (idx == B) {
                answer = Math.min(answer, cnt);
                continue;
            }

            for (int i = 0; i < N; i++) {
                if (bus[idx][i] >= 0) { // 연결된 경우
                    if (v[i] > cnt + bus[idx][i]) { // 더 작은 비용으로 갈 수 있으면 업데이트
                        v[i] = cnt + bus[idx][i];
                        q.add(new int[] { i, cnt + bus[idx][i] });
                    }
                }
            }
        }
    }
}
