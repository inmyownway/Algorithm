import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int result = 0;
        
        
        Arrays.sort(routes,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b)
            {   
            return Integer.compare(a[1],b[1]);
            }
        });
                    
        boolean[] v= new boolean[routes.length];
        
        int l = routes.length;
        int answer=0;
        for(int i=0;i<l;i++)
        {
            
            if(!v[i])
            {
                v[i]=true;
                answer++;
            
                int num = routes[i][1];
            
                for(int j=0;j<l;j++)
                {
                    if(v[j]==false)
                    {
                        if(routes[j][0] <= num  && num<= routes[j][1])
                        {
                            v[j]=true;
                        }
                    }
                }
            }
            
        }
        return answer;
    }
}

//