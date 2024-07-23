import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<int[]> q;
    static ArrayList<String[]> nums;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());

        nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] n = new String[3];
            st = new StringTokenizer(bf.readLine());
            n[0] = st.nextToken();
            n[1] = st.nextToken();
            n[2] = st.nextToken();
            nums.add(n);
        }
        int answer = 0;
        for (int i = 100; i <= 999; i++) {

            // 중복검사 or 0 포함인지

            boolean check = true;

            String now = String.valueOf(i);

            if (now.charAt(0) == now.charAt(1) || now.charAt(0) == now.charAt(2) || now.charAt(1) == now.charAt(2)) {
                check = false;
            }

            if (now.charAt(0) == '0' || now.charAt(1) == '0' || now.charAt(2) == '0') {
                check = false;
            }

            if (!check) {
                continue;
            }
            //  System.out.println(i);
            int cnt = 0;
            for (int j = 0; j < N; j++) {

                String[] n = nums.get(j);
                String num = n[0];
                int ball = 0;
                int strike = 0;
                // 검사

                if (now.charAt(0) == num.charAt(0)) {
                    strike++;

                } else if (now.charAt(0) == num.charAt(1) || now.charAt(0) == num.charAt(2)) {
                    ball++;
                }

                if (now.charAt(1) == num.charAt(1)) {
                    strike++;

                } else if (now.charAt(1) == num.charAt(0) || now.charAt(1) == num.charAt(2)) {
                    ball++;
                }

                if (now.charAt(2) == num.charAt(2)) {
                    strike++;

                } else if (now.charAt(2) == num.charAt(0) || now.charAt(2) == num.charAt(1)) {
                    ball++;
                }

                if (strike == Integer.parseInt(n[1]) && ball == Integer.parseInt(n[2])) {
                    cnt++;
                }

            }
            if (cnt == N) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}