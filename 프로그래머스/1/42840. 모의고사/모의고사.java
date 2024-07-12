import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 정답 개수
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                count1++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                count2++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                count3++;
            }
        }
        
        int max = Math.max(count1, Math.max(count2, count3));
        List<Integer> list = new ArrayList<>();
        
        if (count1 == max) list.add(1);
        if (count2 == max) list.add(2);
        if (count3 == max) list.add(3);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}