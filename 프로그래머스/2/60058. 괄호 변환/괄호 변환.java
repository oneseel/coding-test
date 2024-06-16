import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return p;
        
        // left('('), right(')'), idx(괄호개수)
        int left = 0, right = 0, idx = 0;
        
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') left++;
            else right++;
            
            if (left == right) {
                idx = i + 1;
                break;
            }
        }
        
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        
        // u가 올바른 괄호 문자열인지 확인
        if (check(u)) return u + solution(v);
        
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(solution(v)).append(")");
        sb.append(reverse(u.substring(1, u.length() - 1)));
        
        return sb.toString();
    }
    
    private boolean check (String u) {
        int left = 0, right = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') left++;
            else right++;
            
            if (right > left) return false;
        }
        
        return true;
    }
    
    private String reverse (String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        
        return sb.toString();
    }
}
