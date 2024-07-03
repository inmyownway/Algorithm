import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int testCase = 0; testCase < t; testCase++) {
            N = Integer.parseInt(bf.readLine());

            arr = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr.add(new int[]{x, y});
            }

            Collections.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int answer = 1; // 최소 하나의 원소는 선택됨

            int[] lastSelected = arr.get(0);
            for(int i = 1; i < arr.size(); i++) {
                int[] current = arr.get(i);
                if(lastSelected[1] > current[1]) {
                    answer++;
                    lastSelected = current;
                }
            }

            System.out.println(answer);
        }
    }
}