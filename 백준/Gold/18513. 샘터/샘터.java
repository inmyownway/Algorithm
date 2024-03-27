import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            q.add(n);
            hashMap.put(n, -1);

        }

        int idx = 1;

        while (true) {
           // System.out.println();
        //    System.out.println("idx: "+idx);

            int s = q.size();

            for (int i = 0; i < s; i++) {
                int current = q.poll();
                //System.out.println("current: "+current);

                if (!hashMap.containsKey(current+1)) {
                    q.add(current + 1);
                    hashMap.put(current + 1, -1);
                    answer.add(idx);
                }

                if (chekc())
                    break;

                if (!hashMap.containsKey(current-1) ) {
                    q.add(current - 1);
                    hashMap.put(current - 1, -1);
                    answer.add(idx);
                }
              //  System.out.println(answer);
                if (chekc())
                    break;

            }
            if(chekc())
                break;
         //   System.out.println(answer);
            idx++;

        }

        long sum=0;
        for(int i=0;i<answer.size();i++)
        {
            sum+=answer.get(i);
        }
        System.out.println(sum);

    }

    public static boolean chekc() {
        if (answer.size() == K)
            return true;
    return false;
    }


}