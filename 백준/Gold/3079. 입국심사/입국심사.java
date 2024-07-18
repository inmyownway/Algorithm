import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long[] times;
    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new long[N];

        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(bf.readLine());
        }
        Arrays.sort(times);

        long min = 0;
        long max = times[N - 1] * M;

        answer = max;
        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += mid / times[i];
                if(sum>=M)
                    break;
            }

            if (sum < M) {
                min = mid + 1;

            } else if (sum >= M) {
                answer = mid;
                max = mid - 1;
            }


        }
        System.out.println(answer);

    }

}