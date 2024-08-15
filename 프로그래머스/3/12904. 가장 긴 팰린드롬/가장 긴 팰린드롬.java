class Solution
{
    static int answer= 0;
    
    public int solution(String s)
    {
        int n = s.length();
        // 이중 for문으로 모든 부분 문자열을 확인
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                if(check(s, i, j)){
                    answer = Math.max(answer, j-i);
                }
            }
        }
        return answer;
    }
    
    public static boolean check(String str, int start, int end)
    {
        while(start < end){
            if(str.charAt(start) != str.charAt(end-1)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
