import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int D;
    static long answer;
    static long result;

    static class Node implements Comparable<Node> {
        int p;
        int v;

        public Node(int p, int v) {
            this.p = p;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.p - o.p;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "p=" + p +
                    ", v=" + v +
                    '}';
        }
    }

    static ArrayList<Node> node;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        node = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            node.add(new Node(p, s));
        }

        int start = 0;
        int end;

        Collections.sort(node);
        answer = node.get(0).v;
        int first = node.get(0).p;

        result = answer;
        int i = 1;
        // System.out.println(first);
        while (true) {
            if (i >= N) {
                break;
            }

            Node now = node.get(i);

            if (Math.abs(now.p - first) >= D) {
                while (true) {
                    // 처리
                    // System.out.println(node.get(i));

                    if (Math.abs(node.get(i).p - first) >= D) {

                        answer -= node.get(start).v;
                        first = node.get(++start).p;

                    } else {

                        result = Math.max(result, answer);
                        break;
                    }


                }
            } else {
                //System.out.println(now);
                answer += node.get(i).v;
                result = Math.max(result, answer);
                i++;
            }
        }
        System.out.println(result);


    }

}