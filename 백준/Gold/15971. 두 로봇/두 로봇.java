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

    static int N, S, E;
    static ArrayList<Board>[] board;
    static int[] A;
    static int[] B;
    static boolean[] v;
    static long answer;
    static int[] dist;

    static class Board {
        int next;
        int bridge;

        public Board(int next, int bridge) {
            this.next = next;
            this.bridge = bridge;
        }


    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;
        int maxBridege;

        public Node(int index, int cost, int maxBridege) {
            this.index = index;
            this.cost = cost;
            this.maxBridege = maxBridege;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;
        E = Integer.parseInt(st.nextToken()) - 1;
        answer = Integer.MAX_VALUE;

        board = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            board[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            board[x].add(new Board(y, s));
            board[y].add(new Board(x, s));

        }

        v = new boolean[N];

        PriorityQueue<Node> q = new PriorityQueue<>();

        q.add(new Node(S, 0, 0));
        v[S] = true;

        while (!q.isEmpty()) {

            Node nowNode = q.poll();
            if (nowNode.index == E) {
                System.out.println(nowNode.cost - nowNode.maxBridege);
            }
            for (Board board : board[nowNode.index]) {
                if (!v[board.next]) {
                    v[board.next] = true;
                    q.add(new Node(board.next, nowNode.cost + board.bridge,
                            Math.max(board.bridge, nowNode.maxBridege)));
                }
            }


        }

    }
}