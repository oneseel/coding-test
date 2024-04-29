import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0}; // 탈락한 사람 번호, 몇 번째 차례에 탈락
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 1; i < words.length; i++) {
            // 탈락(이어지지 않는 단어)
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            map.put(words[i - 1], 1);
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            
            // 탈락(중복단어)
            if (map.get(words[i]) > 1) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        }

        return answer;
    }
}