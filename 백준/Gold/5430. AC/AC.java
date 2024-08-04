import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static String command;
    static int N;
    static ArrayList<Integer> arr;
    static boolean forward;
    static boolean isError;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            command = bf.readLine();
            N = Integer.parseInt(bf.readLine());
            arr = new ArrayList<>();
            String str = bf.readLine();

            String num = "";
            forward = true;
            isError = false;

            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == ']') {

                    if (num != "") {
                        arr.add(Integer.parseInt(num));
                    }
                }

                if (str.charAt(i) == ',') {
                    arr.add(Integer.parseInt(num));
                    num = "";
                    continue;
                }
                num += str.charAt(i);

            }

            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'R') {
                    if (forward) {
                        forward = false;
                    } else {
                        forward = true;
                    }
                } else {
                    if (arr.size() == 0) {
                        isError = true;
                        break;
                    }

                    if (forward) {
                        arr.remove(0);
                    } else {
                        arr.remove(arr.size() - 1);
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('[');

                if (forward) {
                    for (int i = 0; i < arr.size(); i++) {
                        if (i == arr.size() - 1) {
                            sb.append(arr.get(i));
                            break;
                        }
                        sb.append(arr.get(i) + ",");
                    }
                } else {
                    for (int i = arr.size() - 1; i > -1; i--) {
                        if (i == 0) {
                            sb.append(arr.get(i));
                            break;
                        }
                        sb.append(arr.get(i) + ",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }


        }


    }
}