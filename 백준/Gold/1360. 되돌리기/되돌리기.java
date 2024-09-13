import java.util.*;
import java.io.*;

public class Main {
    static class Command {
        String com;
        String ch;
        int time;
        boolean flag;

        public Command(String com, String ch, int time, boolean flag) {
            this.com = com;
            this.ch = ch;
            this.time = time;
            this.flag = flag;

        }
    }

    static int N;
    static ArrayList<Command> command;
    static StringBuilder sb;
    static ArrayList<Answer> answer;

    static class Answer {
        int nowTime;
        String state;

        public Answer(int nowTime, String preTime) {
            this.nowTime = nowTime;
            this.state = preTime;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        answer.add(new Answer(0, ""));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            String com = st.nextToken();
            String ch = st.nextToken();
            int time = Integer.parseInt(st.nextToken());

            if (com.equals("type")) {
                answer.add(new Answer(time, answer.get(answer.size() - 1).state + ch));
            } else {

                String str = "";
                for (int j = answer.size() - 1; j >= 0; j--) {
                    if (answer.get(j).nowTime < time - Integer.parseInt(ch)) {

                        str = answer.get(j).state;
                        break;
                    }
                }
                answer.add(new Answer(time, str));
            }
        }
        System.out.println(answer.get(answer.size() - 1).state);


    }


}
