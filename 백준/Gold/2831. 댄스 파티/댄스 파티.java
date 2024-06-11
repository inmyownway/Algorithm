import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static ArrayList<Integer>[] male;
    static ArrayList<Integer>[] female;
    static int pairCnt;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        male = new ArrayList[2];
        female = new ArrayList[2];

        N = Integer.parseInt(st.nextToken());

        male[0] = new ArrayList<>();
        male[1] = new ArrayList<>();
        female[0] = new ArrayList<>();
        female[1] = new ArrayList<>();

        // ArrayList[0] 은 남자 크고 여자 작은곳

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp < 0) {
                male[0].add(Math.abs(temp));
            } else {
                male[1].add(temp);
            }
        }

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp < 0) {
                female[1].add(Math.abs(temp));
            } else {
                female[0].add(temp);
            }
        }
        Collections.sort(male[0]);
        Collections.sort(male[1]);
        Collections.sort(female[0]);
        Collections.sort(female[1]);
        check1();
        check2();
        System.out.println(pairCnt);

    }

    public static void check1() {
        // 남자 크고 , 여자 작음

        for (int i = 0, j = 0; i < male[0].size() && j < female[0].size(); ) {
            int tall = male[0].get(i);
            int small = female[0].get(j);

            if (tall > small) {
                i++;
                j++;
                pairCnt++;
            } else {
                i++;
            }
        }

    }

    /*
5
-5 -4 -3 -2 -1
5 4 3 2 1/
     */
    public static void check2() {
        // 남자 작고 , 여자 크고

        for (int i = 0, j = 0; i < male[1].size() && j < female[1].size(); ) {
            int tall = female[1].get(j);
            int small = male[1].get(i);

            if (tall > small) {
                i++;
                j++;
                pairCnt++;
            } else {
                j++;
            }
        }

    }
}