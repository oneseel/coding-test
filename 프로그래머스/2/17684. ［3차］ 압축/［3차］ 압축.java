import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        
        // 사전 초기화
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put("" + (char)('A' + i), i + 1);
        }
        
        
        int idx = 27;
        for (int i = 0; i < msg.length(); ) {
            String w = "";
            // 가장 긴 문자열 w 찾기
            for (int j = 1; i + j <= msg.length(); j++) {
                String temp = msg.substring(i, i + j);
                if (dictionary.containsKey(temp)) {
                    w = temp;
                } else {
                    break;
                }
            }
        
            list.add(dictionary.get(w));
            if (i + w.length() < msg.length()) {
                dictionary.put(msg.substring(i, i + w.length() + 1), idx++);
            }
            i += w.length();
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}