import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<String> dictionary; // 사전에 있는 단어 리스트
    static String[] letters; // 모음 단어들
    
    public int solution(String word) {
        int answer = 0;
        dictionary = new ArrayList<>();
        letters = new String[] {"A", "E", "I", "O", "U"};
        
        dfs("", 0);
        
        for(int i = 0; i < dictionary.size(); i++) {
            if(dictionary.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public void dfs (String vowel, int depth) {
        dictionary.add(vowel);
        
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i <letters.length; i++) {
            dfs(vowel + letters[i], depth + 1);
        }
    }
}