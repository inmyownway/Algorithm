import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Character> s;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

        // DRINK
        // DRKNI

        // HELLO
        // HELOL

        // abcde
        // abced
        // abdec

        int testCase = Integer.parseInt(st.nextToken());

        for (int test = 0; test < testCase; test++) {

            String str = bf.readLine();

            char[] arr = new char[str.length()];

            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i);
            }

            int startIdx = -1;
            int endIdx = 0;

            boolean flag = false;
            for (int j = arr.length - 1; j >= 1; j--) {

                if (arr[j] > arr[j - 1]) {

                    startIdx = j - 1;
                    break;
                }
            }
            boolean check = false;

            if (startIdx == -1) {

            } else {
                for (int i = arr.length - 1; i >= 1; i--) {
                    if (arr[startIdx] < arr[i]) {

                        endIdx = i;

                        break;
                    }
                }
                // System.out.println(startIdx + " " + endIdx);
                char temp = arr[startIdx];
                arr[startIdx] = arr[endIdx];
                arr[endIdx] = temp;

                Arrays.sort(arr, startIdx + 1, arr.length);
                
            }
            // System.out.println(Arrays.toString(arr) + " " + startIdx);

            String answer = "";
            for (int i = 0; i < arr.length; i++) {
                answer += arr[i];
            }
            System.out.println(answer);
        }
    }
}