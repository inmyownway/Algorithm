import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static int[] dist;
    static int start;
    static ArrayList<Node>[] node;

    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {

            return Integer.compare(this.value, o.value);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(bf.readLine());

        node = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            node[i] = new ArrayList<>();
        }
        dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start - 1] = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            node[x - 1].add(new Node(y - 1, value));
        }

        bfs();
        for (int i = 0; i < V; i++) {
            int d = dist[i];
            if (d == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(d);
            }
        }
    }

    public static void bfs() {
        boolean[] check = new boolean[V];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start - 1, 0));

        while (!q.isEmpty()) {

            int now = q.poll().index;
            //  System.out.println(now);
            if (check[now]) {
                continue;
            }
            check[now] = true;
            for (Node n : node[now]) {

                if (dist[n.index] > n.value + dist[now]) {
                    dist[n.index] = n.value + dist[now];
                    q.add(new Node(n.index, dist[n.index]));
                }
            }
        }
    }

}