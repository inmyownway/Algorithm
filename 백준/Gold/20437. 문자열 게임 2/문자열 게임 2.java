import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static String W;

    static int[] alpha;
    static int max = Integer.MAX_VALUE;
    static int min = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            W = bf.readLine();
            K = Integer.parseInt(bf.readLine());

            max = Integer.MAX_VALUE;
            min = Integer.MIN_VALUE;
            alpha = new int[26];

            if (K == 1) {
                System.out.println(1 + " " + 1);
                continue;
            }

            for (int i = 0; i < W.length(); i++) {
                alpha[W.charAt(i) - 'a']++;
            }

            // System.out.println(Arrays.toString(alpha));
            simul();

            if (min == Integer.MIN_VALUE && max == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(max + " " + min);
            }
        }

    }

    public static void simul() {
        for (int i = 0; i < W.length(); i++) {
            char cur = W.charAt(i);

            if (alpha[cur - 'a'] >= K) {
                int cnt = 1;
                // System.out.println(cur);
                for (int idx = i + 1; idx < W.length(); idx++) {
                    // System.out.println("w: " + W.charAt(idx));
                    if (W.charAt(idx) == cur) {
                        //  System.out.println("@");
                        cnt++;
                    }
                    if (cnt == K) {
                        max = Math.min(idx - i + 1, max);
                        min = Math.max(idx - i + 1, min);
                        break;
                    }

                }
                //System.out.println(max + " " + min);
            }
        }
    }


}