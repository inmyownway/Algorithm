import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String str = bf.readLine();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        Deque<Integer> q = new LinkedList<>();

        q.add(arr[0]);
        for (int i = 1; i < N; i++) {

            while (!q.isEmpty() && K > 0 && q.getLast() < arr[i]) {
                q.removeLast();
                K--;
            }
            q.add(arr[i]);


        }

        int r = q.size() - K;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < r; i++) {
            answer.append(q.removeFirst());

        }
        System.out.println(answer.toString());

    }
}