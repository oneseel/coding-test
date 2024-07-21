import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 이름과 그리움 점수를 맵에 저장
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        // 각 사진마다 그리움 점수를 합산
        for (int i = 0; i < photo.length; i++) {
            for (String person : photo[i]) {
                // 사진에 있는 이름이 맵에 있을 경우 그리움 점수를 더함
                answer[i] += map.getOrDefault(person, 0);
            }
        }
        
        return answer;
    }
}
