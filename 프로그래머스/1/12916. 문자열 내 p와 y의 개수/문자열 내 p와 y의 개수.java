class Solution {
    boolean solution(String s) {
        
        int pCount = 0;
        int yCount = 0;
        
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') {
                pCount++;
            } else if (c == 'y') {
                yCount++;
            }
        }
        
       return pCount == yCount;
    }
}