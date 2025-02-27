import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[] parents;
    static int N;

    public int solution(int n, int[][] wires) {
        N = n;
        for (int i = 0; i < wires.length; i++) {
            // 부모 배열 초기화
            parents = new int[N];
            makeParents();

            // 모든 간선을 연결하되, 하나를 제외하고 연결
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // i번째 간선은 끊음
                int a = wires[j][0] - 1;
                int b = wires[j][1] - 1;
                union(a, b);
            }

            // 두 네트워크의 크기 계산
            int[] count = new int[N]; // 각 그룹의 노드 개수 저장
            for (int k = 0; k < N; k++) {
                int root = find(k);
                count[root]++;
            }

            // 두 네트워크의 차이를 계산
            int sizeA = 0, sizeB = 0;
            for (int c : count) {
                if (c > 0) {
                    if (sizeA == 0) sizeA = c;
                    else sizeB = c;
                }
            }

            answer = Math.min(answer, Math.abs(sizeA - sizeB));
        }
        return answer;
    }

    public static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A != B) {
            parents[B] = A; // 루트끼리 연결
        }
    }

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]); // 경로 압축 적용
    }

    public static void makeParents() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }
}
