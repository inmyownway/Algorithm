import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[] dist;
    static int N;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        N = n;
        graph = new ArrayList[N];
        dist = new int[N];
        
        // 그래프 초기화
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 도로 정보로 그래프 생성
        for (int[] r : roads) {
            int x = r[0] - 1;
            int y = r[1] - 1;
            graph[x].add(y);
            graph[y].add(x);
        }
        
        // 각 노드의 최단 거리 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[destination - 1] = 0;
        
        // 목적지에서 모든 노드로의 최단 거리 계산
        Queue<Integer> q = new LinkedList<>();
        q.add(destination - 1);
        
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        
        // 각 출발지에서 목적지까지의 거리 결과 생성
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i] - 1;
            result[i] = (dist[source] == Integer.MAX_VALUE) ? -1 : dist[source];
        }
        
        return result;
    }
}
