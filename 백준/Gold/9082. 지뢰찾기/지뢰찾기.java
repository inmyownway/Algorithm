import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] cnt;
    static char[] bomb;
    static char[] pre;
    static char[] cur;

    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int test = 0; test < testCase; test++) {

            answer = 0;
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());

            cnt = new int[N];

            String str = bf.readLine();
            for (int i = 0; i < N; i++) {
                cnt[i] = str.charAt(i) - '0';
            }

            str = bf.readLine();
            // System.out.println(Arrays.toString(cnt));
            for (int i = 0; i < N; i++) {
                if (i == 0 && cnt[i] != 0 && cnt[i + 1] != 0) {

                    cnt[i]--;
                    cnt[i + 1]--;

                    answer++;
                } else if (i == N - 1 && cnt[i] != 0 && cnt[i - 1] != 0) {

                    cnt[N - 1]--;
                    cnt[N - 2]--;

                    answer++;
                } else if (i >= 1 && i < N - 1 && cnt[i - 1] != 0 && cnt[i] != 0 && cnt[i + 1] != 0) {
                    cnt[i]--;
                    cnt[i - 1]--;
                    cnt[i + 1]--;
                    answer++;
                }

            }
            System.out.println(answer);


        }
    }
}