import java.util.*;

class Solution {
    static int N;
    static boolean[] v;
    static HashSet<Integer> arr;
    
    public int[] solution(int[] numbers) {
        int[] answer;
        arr = new HashSet<>();
        N = numbers.length;
        v = new boolean[N];
    
        // Start the combination with initial r as 0
        comb(numbers, 0, 0);
        
        // Convert set to array and sort
        answer = new int[arr.size()];
        int index = 0;
        for (int num : arr) {
            answer[index++] = num;
        }
        Arrays.sort(answer);
        
        return answer;
    }

    public static void comb(int[] numbers, int start, int r) {
        if (r == 2) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (v[i]) {
                    sum += numbers[i];
                    count++;
                }
                if (count == 2) break; // Stop if two elements are selected
            }
            arr.add(sum);
            return;
        }
        
        for (int i = start; i < N; i++) {
            v[i] = true;
            comb(numbers, i + 1, r + 1);
            v[i] = false;
        }
    }
}
