import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계 (소문자로 치환)
        String answer = new_id.toLowerCase();
        
        // 2단계 (특수문자 제거)
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        
        // 3단계 (연속된 마침표)
        answer = answer.replaceAll("[.]{2,}", ".");
        
        // 4단계 (마침표의 위치)
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        // 5단계 (빈 문자열)
        if (answer.length() == 0) {
            answer = "a";
        }
        
        // 6단계 (최대 글자수 제한)
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$","");
        }
        
        // 7단계 (최소 글자수 제한)
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer = answer + answer.charAt(answer.length() - 1);
            }
        }
    
        return answer;
    }
}