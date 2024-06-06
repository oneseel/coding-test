import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        int answer = -1;
        
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        // N을 1번 사용한 경우
        dp.get(1).add(N);
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int op1 : dp.get(j)) {
                    for (int op2 : dp.get(i - j)) {
                        dp.get(i).add(op1 + op2);
                        dp.get(i).add(op1 - op2);
                        dp.get(i).add(op1 * op2);
                        if (op2 != 0) {
                            dp.get(i).add(op1 / op2);
                        }
                    }
                }
            }
            // N을 i번 연속으로 사용한 경우 추가
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}
