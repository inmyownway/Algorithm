import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String S = bf.readLine();
        String P = bf.readLine();

        int cnt = 0;

        int tempCnt = 0;
        String str = "";
        int idx = 0;
        for (int i = 0; i < P.length(); i++) {

//            System.out.println("idx: " + idx);

            // System.out.println(P.substring(idx, i + 1));
            // System.out.println();
            if (S.indexOf(P.substring(idx, i + 1)) != -1) {
                continue;
            }
            idx = i;
            cnt++;
        }
        System.out.println(cnt + 1);
    }
}