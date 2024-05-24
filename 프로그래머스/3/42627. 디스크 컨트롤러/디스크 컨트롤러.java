import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간을 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 작업 소요 시간을 기준으로 하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int count = 0;
        int currentTime = 0;
        int sum = 0;
        
        while(count < jobs.length || !pq.isEmpty()) {
            // 현재 시간에 처리 가능한 작업을 우선순위 큐에 추가
            while(count < jobs.length && jobs[count][0] <= currentTime) {
                pq.offer(jobs[count++]);
            }
            
            // 우선순위 큐가 비어있지 않다면, 작업 처리
            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                currentTime += job[1];
                sum += currentTime - job[0];
            } else {
                // 큐가 비어있다면, 다음 작업의 시작 시간으로 현재 시간을 설정
                currentTime = jobs[count][0];
            }
        }
        
        return sum / jobs.length;
    }
}
