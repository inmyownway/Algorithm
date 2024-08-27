import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static String str;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        str = bf.readLine();

        // 파란색 왼쪽으로
        boolean flag;
        int cnt = 0;

        flag = false;
        cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!flag) {
                if (str.charAt(i) == 'R') {
                    flag = true;
                }

            }
            if (flag && str.charAt(i) == 'B') {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        // 빨간 왼쪽
        flag = false;
        cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!flag) {
                if (str.charAt(i) == 'B') {
                    flag = true;
                }

            }
            if (flag && str.charAt(i) == 'R') {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        // 파란오른쪽
        flag = false;
        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (!flag) {
                if (str.charAt(i) == 'R') {
                    flag = true;
                }

            }

            if (flag && str.charAt(i) == 'B') {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        // 빨간 오르쪽

        flag = false;
        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (!flag) {
                if (str.charAt(i) == 'B') {
                    flag = true;
                }

            }
            if (flag && str.charAt(i) == 'R') {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        System.out.println(answer);
    }


}