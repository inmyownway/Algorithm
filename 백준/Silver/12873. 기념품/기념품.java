import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer> person;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        person = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            person.add(i);
        }

        int stage = 1;

        int n = 0;

        while (person.size() > 1) {

            n = (int) ((n + Math.pow(stage, 3) - 1) % person.size());
            int temp = person.size();
            person.remove(n);

            stage++;

        }
        System.out.println(person.get(0));
    }
}