import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int count = 0; // 섞어야 하는 최소 횟수
        
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int mix = first + second * 2;
            
            pq.add(mix);
            count++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }

        return count;
    }
}