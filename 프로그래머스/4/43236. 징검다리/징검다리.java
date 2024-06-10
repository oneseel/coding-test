import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int r = rocks.length; // 바위의 개수
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        // 이진 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2;
            int removeRocks = 0; // 삭제한 바위의 수
            int prevRock = 0; // 이전 바위
            
            for (int rock : rocks) {
                if (rock - prevRock < mid) {
                    removeRocks++;
                } else {
                    prevRock = rock;
                }
            }
            
            if (distance - prevRock < mid) {
                removeRocks++;
            }
            
            if (removeRocks <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}
