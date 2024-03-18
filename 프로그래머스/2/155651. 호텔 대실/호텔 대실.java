import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int[][] times = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = convertTime(book_time[i][0]);
            times[i][1] = convertTime(book_time[i][1]) + 10 * 60; // 청소시간까지 더해준다.
        }
            
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
             
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] time : times) {
            if (!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();
            }
            pq.offer(time[1]);
        }
        
        return pq.size();
    }
    // 시간변환
    private int convertTime(String time) {
        String[] timeArr = time.split(":");
        int hour = Integer.parseInt(timeArr[0]) * 3600;
        int minute = Integer.parseInt(timeArr[1]) * 60;
        return hour + minute;
    }
}