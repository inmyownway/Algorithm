import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Queue<Integer> arr;
    static ArrayList<Integer>[] party;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new LinkedList<>();
        v = new boolean[M];
        st = new StringTokenizer(bf.readLine());
        int k = Integer.parseInt(st.nextToken());

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        while (!arr.isEmpty()) {
            int now = arr.poll();

            for (int j = 0; j < party.length; j++) {

                if (!v[j]) {
                    for (int p = 0; p < party[j].size(); p++) {
                        if (party[j].get(p) == now) {
                            v[j] = true;

                            for (int x = 0; x < party[j].size(); x++) {
                                arr.add(party[j].get(x));
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < v.length; i++) {
            if (!v[i])
                ans++;
        }
        System.out.println(ans);
    }
}