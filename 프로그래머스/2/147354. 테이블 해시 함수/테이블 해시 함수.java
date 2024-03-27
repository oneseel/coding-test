import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // col을 기준으로 오름차순 정렬
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] != o2[col - 1]) {
                return o1[col - 1] - o2[col - 1];
            // col 값이 같다면 기본키 값을 기준으로 내림차순 정렬   
            } else {
                return o2[0] - o1[0];
            }
        });
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int hash = 0;
            for(int num : data[i]) {
                hash += num % (i + 1);
            }
            answer ^= hash;
        }
        
        return answer;
    }
}