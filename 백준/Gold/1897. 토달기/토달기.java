import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<String>[] arr;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[82];
        for (int i = 0; i < 81; i++) {
            arr[i] = new ArrayList<>();
        }

        String startWord = st.nextToken();

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            arr[str.length()].add(str);
        }

        Queue<String> q = new LinkedList<>();
        q.add(startWord);
        while (!q.isEmpty()) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                String now = q.poll();
                answer = now;

                for (String next : arr[now.length() + 1]) {
                    boolean can = check(now, next);

                    if (can) {
                        q.add(next);
                    }
                }

            }
        }
        System.out.println(answer);

    }

    public static boolean check(String now, String next) {
        int x = 0;
        int y = 0;

        int cnt = 0;
        boolean flag = false;
        while (true) {

            if (now.charAt(x) != next.charAt(y)) {
                cnt++;
                y++;
            } else {
                x++;
                y++;

            }

            if (cnt >= 2) {
                return false;
            }
            if (x == now.length())
                break;
        }
        return true;
    }

    // col
    // tcot
}