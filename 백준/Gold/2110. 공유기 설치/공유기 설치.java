import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] home;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        home = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            home[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(home);

        // 집들의 최소 최대 간격
        int low = 1;
        int high = home[N - 1];

        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            int pos = 0;

            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (home[i] - home[pos] >= mid) {
                    pos = i;
                    cnt++;
                }
            }

            // 설치된 공유기가 원래 설치애햐할거보다 적으면
            if (cnt < C) {

                high = mid - 1;// 길이줄여주고

            } else {
                low = mid + 1;
            }

        }
        System.out.println(low-1);
    }
}