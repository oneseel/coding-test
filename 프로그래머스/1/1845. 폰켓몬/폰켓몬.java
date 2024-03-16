import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int temp = nums.length / 2;
        
        if (map.size() > temp) {
            return temp;
        }
        
        return map.size();
    }
}