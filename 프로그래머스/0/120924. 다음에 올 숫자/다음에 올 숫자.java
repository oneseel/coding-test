class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        // 등차수열인지 확인
        if (common[1] - common[0] == common[2] - common[1]) {
            answer = common[common.length - 1] + (common[1] - common[0]); 
            return answer;
        }
        
        // 공비를 구하기
        int temp = common[1] / common[0];
        
        answer = common[common.length - 1] * temp; 
        
        return answer;
    }
}