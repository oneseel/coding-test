class Solution {
    public int solution(int n) {
        int count = 1;
        
        for (int i = 1 ; i <= n; i++) {
            int temp = i;
            for (int j = i; temp <= n; j++) {
                temp += (j + 1);
                if (temp == n) {
                    count++;
                }
            }
        }
        
        return count;
    }
}