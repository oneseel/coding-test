import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        for (String s : skill_trees) {
            if (isValid(skill, s)) count++;
        }
        return count;
    }
    
    private static boolean isValid(String skill, String s) {
        int idx = 0; // 스킬순서
        
        for(char c : s.toCharArray()) {
            // 스킬트리에 있는 값(temp)이 스킬에 있는지 확인
            int temp = skill.indexOf(c);
            
            // 없다면 넘어간다.
            if (temp == -1) continue;
            
            // 있지만 현재순서가 아니면 false
            if (temp != idx) return false;
            idx++;
        }
        return true;
    }
}