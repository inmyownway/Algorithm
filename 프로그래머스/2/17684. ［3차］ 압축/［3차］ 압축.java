import java.io.*;
import java.util.*;


class Solution {


    public static int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] m = msg.split("");
        String[] dir = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z"};

        ArrayList<String> arr = new ArrayList<>();

        Deque<String> q = new ArrayDeque<>();
        for (String mm : m) {
            q.add(mm);
        }
        for (int i = 0; i < 26; i++) {
            arr.add(dir[i]);
        }

        while (!q.isEmpty()) {

            // now = K
            String now = q.peek();

            int idx = arr.indexOf(now);
            // idx= 10
            while (true) {

                boolean flag = false;
                for (int i = 0; i < arr.size(); i++) {
                    if (now.equals(arr.get(i))) {
                        idx = arr.indexOf(now);
                        flag = true;
                    }
                }

                if (!flag) {
                    arr.add(now);

                    answer.add((idx + 1));

                    break;
                } else {
                    q.poll();
                    now += q.peek();


                }


            }


        }

        int[] a = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            a[i] = (answer.get(i));
        }
        return a;
    }

    // [11, 1, 27, 15]
}