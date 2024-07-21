import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        
        // 이름과 그리움 점수를 이용해서 맵을 구성
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                // 사진에 있는 이름이 맵에 있을 경우 그리움 점수를 저장
                if (map.containsKey(photo[i][j])) {
                     answer[i] += map.get(photo[i][j]);
                }
            }
        }
        
        return answer;
    }
}