import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] inputA = bf.readLine().split("");
        String[] inputB = bf.readLine().split("");

        dp = new int[inputA.length + 1][inputB.length + 1];

        for (int i = 0; i < inputA.length; i++) {
            for (int j = 0; j < inputB.length; j++) {
                if (inputA[i].equals(inputB[j])) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        String answer = "";

        int lenA = inputA.length;
        int lenB = inputB.length;

        while (lenA != 0 && lenB != 0) {

            if (inputA[lenA - 1].equals(inputB[lenB - 1])) {
                answer += inputA[lenA - 1];
                lenA -= 1;
                lenB -= 1;
            }

            else if (dp[lenA - 1][lenB] == dp[lenA][lenB]) {
                lenA -= 1;
            } else
                lenB -= 1;
            } 


        
        String ans = "";
        for (int i = answer.length() - 1; i >= 0; i--)// answer.length(); i++) {
        {
            ans += answer.charAt(i);
        }
        System.out.println(ans.length());
        if (ans.length() != 0) {
            System.out.println(ans);
        }
    }
}