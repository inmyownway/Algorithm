import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        Queue<String> in = new LinkedList<>();
        Queue<String> out = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            in.add(bf.readLine());
        }
        for (int i = 0; i < N; i++) {
            out.add(bf.readLine());
        }

        for (int i = 0; i < N; i++) {
            if (in.peek().equals(out.peek())) {
                in.poll();
                out.poll();
            } else {
                answer++;
                in.remove(out.poll());
            }

        }
        System.out.println(answer);
    }
}