import java.util.*;
import java.io.*;

public class Main {

    static String X;
    static char[] data;
    static char[] word;
    static int N;
    static int R;
    static boolean[] v;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        arr = new ArrayList<>();
        X = st.nextToken();

        N = X.length();
        R = X.length();

        data = new char[N];
        for (int i = 0; i < N; i++) {
            data[i] = X.charAt(i);
        }
        word = new char[R];
        v = new boolean[R];
        permu(0);

        Collections.sort(arr);

        int answer = 0;
        for (int i = arr.size() - 1; i > -1; i--) {
            if (arr.get(i) > Integer.parseInt(X)) {
                answer = arr.get(i);
            }
        }
        System.out.println(answer);

    }

    public static void permu(int idx) {
        if (idx == R) {

            String str = "";
            for (int i = 0; i < N; i++) {

                str += word[i];
            }

            arr.add(Integer.parseInt(str));

            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) {
                continue;
            }

            word[idx] = data[i];
            v[i] = true;
            permu(idx + 1);
            v[i] = false;

        }
    }


}