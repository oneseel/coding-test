import java.util.*;

class Solution {
    private static List<String> dictionary; // 모든 가능한 단어 조합
    private static String[] vowels; // 모음들
    
    public int solution(String word) {
        dictionary = new ArrayList<>();
        vowels = new String[]{"A", "E", "I", "O", "U"};

        dfs("", 0);
        int answer = 0;

        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).equals(word)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    private static void dfs(String vowel, int length) {
        dictionary.add(vowel);

        if (length == 5) {
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
            dfs(vowel + vowels[i], length + 1);
        }
    }
}