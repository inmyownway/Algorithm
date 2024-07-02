import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
            
        // Arrays.sort(routes, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] route1, int[] route2) {
        //         return route1[1] - route2[1];
        //     }
        // });
           Arrays.sort(routes,new Comparator<int[]>(){
            @Override
            public int compare(int[] route1,int[] route2){
                return route1[1]-route2[1];
            }
        });
      
        
        int cam= Integer.MIN_VALUE;
        
        for(int i=0;i<routes.length;i++)
        {
            if(cam < routes[i][0]){
                answer++;
                cam=routes[i][1];
            }
        }
        return answer;
    }
}