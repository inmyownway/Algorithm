import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Room {

        char type;
        ArrayList<Integer> arr;
        int money;
        int currentMoney;

        public Room(char type, ArrayList<Integer> arr, int money, int currentMoney) {
            this.type = type;
            this.arr = arr;
            this.money = money;
            this.currentMoney = currentMoney;
        }
    }

    static int N;
    static ArrayList<Room> room;
    static int[] v;
    static boolean answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //= new StringTokenizer(bf.readLine());

        while (true) {

            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            answer = false;
            if (N == 0) {
                break;
            }
            room = new ArrayList<>();

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(bf.readLine());

                v = new int[N];

                Arrays.fill(v, -1);
                String command = st.nextToken();
                int money = Integer.parseInt(st.nextToken());
                ArrayList<Integer> arr = new ArrayList<>();
                while (true) {
                    int n = Integer.parseInt(st.nextToken());
                    if (n == 0) {
                        break;
                    }
                    arr.add(n - 1);
                }
                room.add(new Room(command.charAt(0), arr, money, 0));
            }

            bfs();
            if (answer) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }

    public static void bfs() {
        int[] now = new int[]{0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(now);

        while (!q.isEmpty()) {
            int[] n = q.poll();
            // System.out.println(Arrays.toString(n));

            int rommNumber = n[0];

            int money = n[1];

            Room nowRoom = room.get(rommNumber);
            // System.out.println(nowRoom.type);
            if (nowRoom.type == 'L') {
                if (money < nowRoom.money) {
                    money = nowRoom.money;
                }
            } else if (nowRoom.type == 'T') {
                money -= nowRoom.money;
            }
            if (money < 0) {
                continue;
            }
            if (rommNumber == N - 1) {
                answer = true;
                return;
            }
            //System.out.println(rommNumber + " " + money);

            //System.out.println();
            //  System.out.println();
            for (int i : nowRoom.arr) {
                if (v[i] < money) {
                    v[i] = money;
                    q.add(new int[]{i, money});

                }
                // System.out.println("i로 고 " + i);

            }

        }
    }


}