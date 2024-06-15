import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 1; t < testCase + 1; t++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String number = Integer.toBinaryString(M);
            String checkBit = Integer.toBinaryString((1 << (N - 1)));

            boolean check = true;
            if (checkBit.length() > number.length()) {
                check = false;
            } else {
                for (int n = 0; n < N; n++) {
                    if (number.charAt(number.length() - 1 - n) - '0' != 1) {
                        check = false;
                    }
                }
            }

            if (check) {
                System.out.println("#" + t + " ON");
            } else {
                System.out.println("#" + t + " OFF");
            }

        }
    }
}