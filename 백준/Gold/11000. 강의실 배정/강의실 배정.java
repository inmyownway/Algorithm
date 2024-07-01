import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {

            if (this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }


    }

    static ArrayList<Node> node;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        node = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            node.add(new Node(s, e));
        }
        Collections.sort(node);

        PriorityQueue<Integer> time = new PriorityQueue<>();

        time.add(node.get(0).end);

        for (int i = 1; i < N; i++) {
            if (time.peek() <= node.get(i).start) {
                time.poll();
            }
            time.add(node.get(i).end);

        }

        System.out.println(time
                .size());

    }
}