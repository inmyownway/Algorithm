import java.util.*;

class Solution {

    static int N;
    static boolean[] v;
    static int[] distance;
    static int d;

    public int solution(int n, int[][] edge) {
        
        N = n;
        v = new boolean[N + 1];  // 노드의 방문 여부를 저장하는 배열
        distance = new int[N + 1];  // 각 노드까지의 거리를 저장하는 배열
        Arrays.fill(distance, -1);  // -1로 초기화하여 방문 여부를 나타냄
        
        d = edge.length;
        Queue<int[]> q = new LinkedList<>();
        
        // 시작 노드 1에서 출발
        q.add(new int[]{1, 0});
        distance[1] = 0;  // 시작 노드까지의 거리는 0
        v[1] = true;  // 노드 1을 방문 처리
        
        // BFS 탐색 시작
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowNode = now[0];
            int dis = now[1];
            
            // 현재 노드와 연결된 모든 간선을 확인
            for (int i = 0; i < d; i++) {
                if (edge[i][0] == nowNode && !v[edge[i][1]]) {
                    // edge[i][0] -> edge[i][1]로 가는 경로 처리
                    distance[edge[i][1]] = dis + 1;
                    v[edge[i][1]] = true;
                    q.add(new int[]{edge[i][1], dis + 1});
                } else if (edge[i][1] == nowNode && !v[edge[i][0]]) {
                    // edge[i][1] -> edge[i][0]로 가는 경로 처리 (양방향)
                    distance[edge[i][0]] = dis + 1;
                    v[edge[i][0]] = true;
                    q.add(new int[]{edge[i][0], dis + 1});
                }
            }
        }

        // 가장 먼 거리 구하기
        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }
        
        // 가장 먼 거리를 가진 노드의 개수 구하기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(Arrays.toString(distance));

        // 가장 먼 노드들의 개수를 반환
        return count;
    }
}
