import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String phone : phoneBook) {
            map.put(phone, 1);
        }
        
        for(String phone : phoneBook) {
            for(int i = 0; i < phone.length(); i++) {
                if(map.containsKey(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
