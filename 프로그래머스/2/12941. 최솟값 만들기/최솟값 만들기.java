import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // A는 오름차순, B는 내림차순으로 정렬
        Arrays.sort(A);
        Integer[] B2 = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(B2, (o1, o2) -> o2 - o1);
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B2[i];
        }
        
        return answer;
    }
}