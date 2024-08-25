import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] fruit;
    static int[] idx;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        fruit = new int[N];
        idx = new int[10];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            fruit[i] = n;

        }

        int left = 0;
        int right = 0;
        int index = 0;
        int cnt = 0;

        int kind = 0;

        while (right < N) {

            if (idx[fruit[right]] == 0) {
                kind++;
            }

            cnt++;
            idx[fruit[right]]++;

            //
            if (kind > 2) {
                while (true) {
                    if (kind == 2) {
                        break;
                    }

                    if (idx[fruit[left]] - 1 == 0) {
                        kind--;
                    }
                    idx[fruit[left]] -= 1;
                    left++;
                    cnt--;
                }
            }
            right++;
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);


    }

}