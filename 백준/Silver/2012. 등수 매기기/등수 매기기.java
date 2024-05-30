import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr.add(Integer.parseInt(st.nextToken()));

            rank[i] = i + 1;
        }

        Collections.sort(arr);

        Long sum = 0L;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(arr.get(i) - rank[i]);
        }
        System.out.println(sum);

    }
}