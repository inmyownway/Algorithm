import java.util.*;
class Solution {
    static int N;
    public long solution(int[] sequence) {
        long answer = 0;
        N= sequence.length;
        long[] dpA = new long[N];
        long[] dpB = new long[N];
        
        int[] A= new int[sequence.length];
        int[] B= new int[sequence.length];
    int n=1;
        for(int i=0;i<N;i++)
        {
        
            A[i]=sequence[i]*n;
           
            B[i]=sequence[i]*(-n);
             n*=-1;
        }
        
        dpA[0]=A[0];
        dpB[0]=B[0];
        
        answer= Math.max(A[0],B[0]);
        
        for(int i=1;i<N;i++)
        {
            dpA[i]=Math.max(dpA[i-1]+A[i],A[i]);
            dpB[i]=Math.max(dpB[i-1]+B[i],B[i]);

            long max= Math.max(dpA[i],dpB[i]);
            answer= Math.max(max,answer);
        }
        return answer;
    }
}