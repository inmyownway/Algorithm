import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<String> arr;
    static String answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        arr = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        answer = "";
        for (int i = 0; i < N; i++) {
            arr.add(bf.readLine());
            // System.out.println(arr.get(i));
        }

        for (int i = 0; i < arr.get(0).length(); i++) {
            boolean flag = true;

            char current = arr.get(0).charAt(i);

            //System.out.println(current);
            for (int j = 1; j < N; j++) {

                //System.out.println("!" + arr.get(j).charAt(j));
                if (current != arr.get(j).charAt(i)) {

                    flag = false;
                    break;
                }


            }
            if (!flag) {
                answer += "?";
            } else {
                answer += current;
            }
        }
        System.out.println(answer);
    }
}