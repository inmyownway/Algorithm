import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<String> nums;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());

            nums = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                nums.add(st.nextToken());
            }

            boolean flag = true;
            Collections.sort(nums);
            for (int i = 0; i < N - 1; i++) {
                if (nums.get(i + 1).startsWith(nums.get(i))) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}