import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] v;
    static int cnt;
    static String[] numbers;
    static String origin;
    static Set<String> set;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        origin = bf.readLine();

        numbers = origin.split("");
        set = new HashSet<>();
        v = new boolean[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            dfs(i, i, numbers[i], numbers[i]);//

        }
        System.out.println(set.size());

    }

    public static void dfs(int leftIdx, int rightIdx, String str, String order) {

        if (leftIdx == 0 && rightIdx == numbers.length - 1) {

            set.add(order);
            return;
        }

        if (leftIdx - 1 >= 0) {
            String order1 = order + numbers[leftIdx - 1] + str;

            dfs(leftIdx - 1, rightIdx, numbers[leftIdx - 1] + str, order1);
        }
        if (rightIdx + 1 < numbers.length) {
            String order2 = order + str + numbers[rightIdx + 1];
            dfs(leftIdx, rightIdx + 1, str + numbers[rightIdx + 1], order2);
        }

    }

}