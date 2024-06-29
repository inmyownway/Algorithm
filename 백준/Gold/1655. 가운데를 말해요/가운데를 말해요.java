import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        // 최소 힙가 최대힙 같으면
        // 최대 힙에 넣어줌 , 아니면 최소힙

        // 최대힙의 루트 노드가 최소힙의 루트보다 크면, 위치바꿔줌
        // 가운데수는 최대힙의 루트

        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(bf.readLine());

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
            }

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int temp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(temp);
                }
            }

            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb.toString());

    }

}