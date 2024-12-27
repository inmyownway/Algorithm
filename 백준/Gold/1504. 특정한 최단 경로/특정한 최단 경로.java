import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static int N, M;
    static ArrayList<Node>[] arr;
    static int INF = 200000000;
    static int nx1, nx2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = (ArrayList<Node>[]) new ArrayList[N]; // 명시적 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            arr[x].add(new Node(y, c));
            arr[y].add(new Node(x, c));
        }

        st = new StringTokenizer(bf.readLine());
        nx1 = Integer.parseInt(st.nextToken()) - 1;
        nx2 = Integer.parseInt(st.nextToken()) - 1;

        int res1 = dijkstra(0, nx1) + dijkstra(nx1, nx2) + dijkstra(nx2, N - 1);
        int res2 = dijkstra(0, nx2) + dijkstra(nx2, nx1) + dijkstra(nx1, N - 1);

        if (res1 >= INF && res2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(res1, res2));
        }
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] dist = new int[N];
        Arrays.fill(dist, INF);

        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int cur = now.idx;

            for (Node next : arr[cur]) {
                if (dist[next.idx] > dist[cur] + next.cost) {
                    dist[next.idx] = dist[cur] + next.cost;
                    q.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        return dist[end];
    }
}
