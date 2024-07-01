import java.util.*;

class Solution {
    
    static List<List<Integer>> graph;
    static int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        bfs(destination, n);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]];
        }
        
        return answer;
    }
    
    private void bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph.get(current)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = dist[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
    }
}
