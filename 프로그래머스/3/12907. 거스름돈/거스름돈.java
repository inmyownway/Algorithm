class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 합이 0을 만드는 방법은 1가지(아무 것도 선택하지 않는 것)

        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        
        return dp[n];
    }
}
