import java.util.*;
import java.io.*;

public class Main {
    static int K, L;
    static LinkedHashSet<String> arr;
    static ArrayList<String> lastOne;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new LinkedHashSet<>();
        lastOne = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            String str = bf.readLine();
     
            if (!arr.contains(str)) {
                arr.add(str);

            } else {

                arr.remove(str);
                arr.add(str);
            }
        }

        int idx = 0;

        for (String ans : arr) {
            if (idx == K) {
                break;
            }

            System.out.println(ans);
            idx++;

        }


    }

}