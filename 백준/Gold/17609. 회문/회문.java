import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.StringTokenizer;

public class Main {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            String str = bf.readLine();
            //System.out.println(str);
            int left = 0;
            int right = str.length() - 1;

            ans = 0;
            int ans = start(str, left, right, 0);
            System.out.println(ans);
        }

    }

    public static int start(String str, int left, int right, int cnt) {

        if (cnt >= 2) {
            return 2;
        }

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {

                left++;
                right--;
            } else {
                return Math.min(start(str, left + 1, right, cnt + 1), start(str, left, right - 1, cnt + 1));
            }
        }
        return cnt;

    }
}