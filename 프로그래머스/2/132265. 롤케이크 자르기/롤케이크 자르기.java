import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // <토핑번호, 토핑개수>
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        // map2에 모든 토핑에 따른 개수를 구한다.
        for (int t : topping) {
            map2.put(t, map2.getOrDefault(t, 0) + 1);
        }
        
        // map1에 토핑을 하나씩 넣고, map2는 뺴주면서 비교한다.
        for (int t : topping) {
            map1.put(t, map1.getOrDefault(t, 0) + 1);
            
            if (map2.get(t) - 1 == 0) {
                map2.remove(t);
            } else {
                map2.put(t, map2.get(t) - 1);
            }
            
            if (map1.size() == map2.size()) {
                answer++;
            }
            
        }
        return answer;
    }
}