import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {

            v = new boolean[10];
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int ans = 0;
            int num = 0;
            while (true) {

                if (cnt == 10) {
                    break;
                }

                num += n;
                String number = Integer.toString(num);
                for (int i = 0; i < number.length(); i++) {
                    if (!v[number.charAt(i) - '0']) {
                        v[number.charAt(i) - '0'] = true;
                        cnt++;
                    }
                }

                ans++;
            }
            System.out.println("#" + (t + 1) + " " + num);
        }
    }
}