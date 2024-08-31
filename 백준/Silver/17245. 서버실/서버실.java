import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long left, right;
    static long[][] com;
    static long comCnt;
    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        com = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {

                com[i][j] = Long.parseLong(st.nextToken());
                comCnt += com[i][j];
                right = Math.max(com[i][j], right);
            }
        }
        left = 0;

        //System.out.println(comCnt);
        while (left <= right) {
            long mid = (right + left) / 2;
            //System.out.println(mid);
            long ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (com[i][j] - mid < 0) {
                        ans += com[i][j];
                    } else {
                        ans += mid;
                    }
                }


            }

            long a =0;
            if(comCnt%2==0)
            {
                a=comCnt/2;
            }
            else
            {
                a=comCnt/2 +1;
            }
            
            if (ans >= a) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            // System.out.println(left + " " + right);

        }
        System.out.println(answer);
    }
}