import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] arr;
    static ArrayList<Word> word;

    static class Word implements Comparable<Word> {

        String w;
        char alpha;
        int num;

        Word(String w, char alpha, int num) {
            this.w = w;
            this.alpha = alpha;
            this.num = num;
        }

        @Override
        public int compareTo(Word o) {

            if (alpha == o.alpha) {
                return Integer.compare(num, o.num);
            }
            return Character.compare(alpha, o.alpha);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        int t = 0;
        word = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Stack<String> s = new Stack<>();
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                String str = st.nextToken();
                String[] w = str.split("-");
                q.add(str);
                word.add(new Word(str, w[0].charAt(0), Integer.parseInt(w[1])));
            }
            t += 5;
        }

        Collections.sort(word);
//        for (Word w : word) {
//
//            System.out.print(w.w + " ");
//        }

        int idx = 0;
        boolean flag = true;
        while (true) {

            String target = word.get(idx).w;

            // 있는 경우
//            System.out.println("target: " + target);
//            System.out.println("q: " + q);
//            System.out.println("s: " + s);
            if (!q.isEmpty() && target.equals(q.peek())) {
                q.poll();
                idx++;
            } else if (s.size() >= 1 && target.equals(s.peek())) {
                //   System.out.println("pop" + idx);
                s.pop();
                idx++;
            } else if (q.size() >= 1) {
                s.add(q.poll());
            } else {
                break;
            }

            if (idx == N * 5) {
                break;
            }


        }
//
//        System.out.println(q);
//        System.out.println(s);
//        System.out.println(flag);
        if (!q.isEmpty() || s.size() >= 1) {
            //   System.out.println("!");
            flag = false;
        }

        if (flag) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD");
        }

    }
}