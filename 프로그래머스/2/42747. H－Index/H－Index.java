import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // Sort the citations array in ascending order
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            // Calculate the number of papers with citations greater than or equal to citations[i]
            int h = n - i;
            
            // Check if the current value satisfies the condition for H-index
            if (citations[i] >= h) {
                return h;
            }
        }
        
        // If no valid H-index is found, return 0
        return 0;
    }
}
