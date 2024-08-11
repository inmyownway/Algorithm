class Solution {
    static int[][] island;
    static int N;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        N=n;
        island= new int[N][N];
        for(int i=0;i<N;i++)
        {
        for(int j=0;j<N;j++)
        {
            island[i][j]=Integer.MAX_VALUE;
        }
        
        }
        for(int[] cost:costs)
        {
            int a= cost[0];
            int b= cost[1];
            int c= cost[2];
            
            island[a][b]=Math.min(island[a][b],c);
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
            answer+=island[i][j];
            }
        }
        
        return answer;
    }
}