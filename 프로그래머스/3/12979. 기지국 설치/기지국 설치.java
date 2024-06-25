class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start=1;
        int idx=0;
        while(start<=n)
        {

            
            if(idx>= stations.length || start < stations[idx]-w)
            {
                answer++;
                start = start+(w*2) +1;
                
            }
            else{
                
                start= stations[idx]+w +1;
                idx++;
            }
        }
        return answer;
    }
}