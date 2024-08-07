import java.util.*;
import java.io.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++)
        {
            pq.add(works[i]);
        }
        while(n>0)
        {
            int num =pq.poll();

            if((num-1)<=0)
            {
                pq.add(0);
            }
            else{
            pq.add((num-1));}
            n--;
        }
        while(!pq.isEmpty())
        {
            int num=pq.poll();           
            answer+= num*num;
        }
        return answer;
    }
}