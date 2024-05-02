import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> deque = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int time = 0; // 총 실행시간
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String city : cities) {
            city = city.toUpperCase();
            // 세트에 도시가 없고, 덱의 크기가 캐시 크가와 동일하면 마지막 방문페이지를 제거한다.
            if (!set.contains(city)) {
                time += 5;
                if (deque.size() == cacheSize) {
                    String last = deque.removeLast();
                    set.remove(last);
            }
               
            // 세트에 도시가 있을 경우, 일단 덱에서 제거하고 새롭게 추가한다.
            } else {
                deque.remove(city);
                time += 1;
            }
            
            deque.push(city);
            set.add(city);
        }
        
        return time;
    }
}