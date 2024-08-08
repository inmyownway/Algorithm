import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        // 합이 n보다 작으면 -1 반환
        if (s < n) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int num = s / n; // 각 자리에 들어갈 기본 값
        int div = s % n; // 나머지 값 (나머지만큼의 자리에는 1을 더해준다)
        
        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }
        
        // 뒤쪽에서부터 div 개수 만큼 1을 더해줌
        for (int i = 0; i < div; i++) {
            answer[n - 1 - i]++;
        }
        
        return answer;
    }
}
