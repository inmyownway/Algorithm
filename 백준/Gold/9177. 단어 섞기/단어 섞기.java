import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static String resultWord;
    static boolean flag;
    static boolean[][][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            Queue<Character> first = new LinkedList<>();
            Queue<Character> second = new LinkedList<>();

            st = new StringTokenizer(bf.readLine());

            String firstWord = st.nextToken();
            String secondWrod = st.nextToken();

            resultWord = st.nextToken();

            for (int i = 0; i < firstWord.length(); i++) {
                first.add(firstWord.charAt(i));
            }

            for (int i = 0; i < secondWrod.length(); i++) {
                second.add(secondWrod.charAt(i));
            }

            int idx = 0;

            flag = false;
            memo = new boolean[first.size() + 1][second.size() + 1][resultWord.length() + 1];
            dfs(first, second, 0);

            String answer = "yes";
            if (flag == false) {
                //|| idx != resultWord.length()) {
                answer = "no";
            }
            System.out.println("Data set " + (t + 1) + ": " + answer);
        }


    }

    public static void dfs(Queue<Character> first, Queue<Character> second, int idx) {
        if (first.isEmpty() && second.isEmpty()) {
            flag = true;
            return;
        }

        char current = resultWord.charAt(idx);
//        System.out.println(current);
//        System.out.println(first);
//        System.out.println(second);
//        System.out.println();

        if (memo[first.size()][second.size()][idx]) {
            return;
        }
        memo[first.size()][second.size()][idx] = true;
        if (!first.isEmpty() && !second.isEmpty() && (current == first.peek() && current == second.peek())) {

            Queue<Character> firstCopy = new LinkedList<>(first);
            Queue<Character> secondCopy = new LinkedList<>(second);

            firstCopy.poll();
            secondCopy.poll();

            dfs(first, secondCopy, idx + 1);
            dfs(firstCopy, second, idx + 1);

        } else if (!first.isEmpty() && first.peek() == current) {
            first.poll();
            dfs(first, second, idx + 1);

        } else if (!second.isEmpty() && second.peek() == current) {
            second.poll();
            dfs(first, second, idx + 1);
        } else {
            return;
        }


    }

}