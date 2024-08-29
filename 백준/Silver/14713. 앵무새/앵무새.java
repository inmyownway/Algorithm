import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<String> sen;
    static String[] ans;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        sen = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            sen.add(bf.readLine());
        }

        String str = bf.readLine();
        ans = str.split(" ");
        v = new boolean[ans.length];
        boolean flag = false;

        for (String s : sen) {
            //System.out.println(s);
            String[] c = s.split(" ");

            Queue<String> q = new LinkedList<>();
            for (String cc : c) {
                q.add(cc);
            }

            for (int i = 0; i < ans.length; i++) {
                if (!q.isEmpty() && q.peek().equals(ans[i])) {
                    v[i] = true;
                    q.poll();
                }
            }

            if (!q.isEmpty()) {
                flag = true;
            }


        }

        boolean lastCheck = true;

        for (int i = 0; i < v.length; i++) {
            if (!v[i]) {
                lastCheck = false;
                //pen pineapple apple pen
            }
        }

        if (!flag && lastCheck) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }


    }
}
