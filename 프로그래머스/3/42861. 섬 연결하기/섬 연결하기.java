import java.util.*;
class Solution {
    static int[][] island;
    static int N;
    static int[] parents;
    
    static void makeParents()
    {
        parents= new int[N];
        for(int i=0;i<N;i++)
        {
            parents[i]=i;
        }
    }
    static int find(int x)
    {
        if(x==parents[x])
            return x;
        
        return parents[x]=find(parents[x]);
    }
    static void union(int a,int b)
    {
        int aRoot= find(a);
        int bRoot= find(b);
        
        if(aRoot!=bRoot)
            parents[bRoot]=aRoot;
    
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        N=n;
        
        makeParents();
        
Arrays.sort(costs, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[2], o2[2]);
    }
});

        
        for(int[] edge:costs)
        {
            int from= edge[0];
            int to =edge[1];
            int cost = edge[2];
            
            int fromParent = find(from);
            int toParent = find(to);
            
            if(fromParent == toParent)
                continue;
            union(fromParent,toParent);
            answer+=cost;
        }
        return answer;
    }
}