import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, D;
    static int[] arr;
    static int answer;
    static ArrayList<Rule> rules;

    public static class Rule {
        public Rule(int start, int end, int term) {
            this.start = start;
            this.end = end;
            this.term = term;
        }

        int start;
        int end;
        int term;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        rules = new ArrayList<>();
        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int term = Integer.parseInt(st.nextToken());

            rules.add(new Rule(start, end, term));

        }

        int left = 0;
        int right = N;
        answer = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;

            long cnt = 0;

            for (Rule r : rules) {
                if (r.start > mid) {
                    continue;
                }
                int end = Math.min(r.end, mid);
                cnt += (end - r.start) / r.term + 1;

            }

            if (cnt >= D) {
                right = mid - 1;

                answer = Math.min(answer, mid);
                continue;


            }
            left = mid + 1;
        }

        System.out.println(answer);
    }

}