import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int col = board.length;
        int row = board[0].length;
        int[][] dp = new int[col][row];
        
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                dp[i][j] = board[i][j]; 
            }
        }
        
        int answer = board[0][0];
        
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                if (dp[i][j] != 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1; 
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        return answer * answer;
    }
}
