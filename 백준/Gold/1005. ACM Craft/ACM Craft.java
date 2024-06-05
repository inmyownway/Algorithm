import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] board;
    static int[] time;
    static int[] degree;
    static List<Integer>[] list;
    static int answer;
    static int startNode;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(bf.readLine());

            answer = 0;

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N];
            degree = new int[N];

            list = new ArrayList[N];

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {

                time[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();

            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                list[x].add(y);
                degree[y]++;
            }

            startNode = Integer.parseInt(bf.readLine()) - 1;

            start();

        }

    }

    public static void start() {

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = time[i];
            if (degree[i] == 0)
                q.add(i);
        }

        // 건물 짓는 비용 안들면 ( 초기건물은 큐에 넣어줌 이걸로 시작할거임)

        while (!q.isEmpty()) {
            int current = q.poll();

            for (Integer next : list[current]) {
                result[next] = Math.max(result[next], result[current] + time[next]);

                degree[next]--;
                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }
        System.out.println(result[startNode]);

    }
}