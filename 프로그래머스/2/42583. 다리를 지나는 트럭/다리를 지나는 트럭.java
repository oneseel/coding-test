import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int totalWeight = 0;
        
        for(int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck);
                    totalWeight += truck;
                    answer++;
                    break;
                } else if (queue.size() == bridge_length) {
                     totalWeight -= queue.poll();
                } else if (totalWeight + truck > weight) {
                    queue.add(0);
                    answer++;
                } else {
                    queue.add(truck);
                    totalWeight += truck;
                    answer++;
                    break;
                }
            }
        }
        
        return answer + bridge_length;
    }
}