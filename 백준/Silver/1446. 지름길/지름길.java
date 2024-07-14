import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int N, D;

    static class SP implements Comparable<SP> {
        int s;
        int e;
        int d;

        public SP(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(SP o) {
            return this.s - o.s;
        }


    }

    static ArrayList<SP> sp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        sp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            sp.add(new SP(s, e, d));
        }

        Collections.sort(sp);
        dfs(0, 0, 0);
        System.out.print(answer);
    }

    public static void dfs(int idx, int cur, int sum) {
       
        if (idx == N) {
            if (cur > D) {
                return;
            } else if (cur == D) {
                answer = Math.min(answer, sum);


            } else {
                answer = Math.min(answer, sum + D - cur);
            }
            return;
        }

        // 이 shortPath 탈수있음

        SP now = sp.get(idx);
        //System.out.print(idx);

        //탄다

        if (cur <= now.s) {
            dfs(idx + 1, now.e, sum + now.d + (now.s - cur));
        }
        //안탄다
        dfs(idx + 1, cur, sum);
    }
}