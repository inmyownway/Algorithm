import java.util.*;
import java.io.*;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        str = st.nextToken();

        int N = str.length();
        boolean[] v = new boolean[N];
        char[] sound = new char[]{'q', 'u', 'a', 'c', 'k'};
        int cnt = 0;

        while (true) {

            int i = 0;
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if (!v[j]) {
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            boolean noQuack = false;
            for (int idx = 0; idx < N; idx++) {
                if (v[idx]) {
                    continue;
                }

                if (str.charAt(idx) == sound[i]) {
                    noQuack = true;
                    v[idx] = true;
                    i++;
                    if (i == 5) {
                        i = 0;
                    }
                }
            }
            cnt++;
            //System.out.println(Arrays.toString(v));

            if (!noQuack || (noQuack && i != 0)) {
                cnt = 0;
                break;
            }


        }
        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }

    }
}