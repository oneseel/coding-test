import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지별 도전자 수
        // N + 2인 이유 : 1스테이지부터 시작하고, 모든 스테이지를 통과한 경우도 저장하기 위해
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }
        
        // 스테이지별 실패한 사용자 수
        Map<Integer, Double> map = new HashMap<>();
        double total = stages.length; // 스테이지별 참가자
        
        // 각 스테이지별 실패율
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) map.put(i, 0.0); // 참가자가 없으면 실패율은 0
            else {
                map.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }
        
        // 내림차순 정렬
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
        
        return list.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}