import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int currentWeight = 0; // 현재 다리의 무게
        int idx = 0; // 트럭 인덱스
        int count = 0; // 시간
        
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }
        
        while (idx < truck_weights.length) {
            currentWeight -= queue.poll();
            
            if (currentWeight + truck_weights[idx] <= weight) {
                queue.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                queue.offer(0);
            }
            count++;
        }
        
        return count + bridge_length;
    }
}