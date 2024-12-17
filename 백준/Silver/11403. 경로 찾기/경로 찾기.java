import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] arr;
    static int N;
    static int[][] answer;
    static int[][] graph;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String temp = "";
            for (int j = 0; j < N; j++) {
                temp += answer[i][j] + " ";
            }

            sb.append(temp + "\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        boolean[][] v = new boolean[N][N];

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < N; i++) {
                if (graph[now][i] == 1 && !v[now][i]) {
                    q.add(i);
                    v[now][i] = true;
                    answer[node][i] = 1;
                }
            }
        }
    }
}
