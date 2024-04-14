import java.util.*;

class Solution {
    public int solution(String[] board) {
        String[][] boards = new String[3][3];
        int O = 0; // O 개수
        int X = 0; // X 개수
        int etc = 0; // . 개수
        
        for (int i = 0; i < board.length; i++) {
            String[] s = board[i].split(""); 
            for (int j = 0; j < s.length; j++) {
                boards[i][j] = s[j];
                if (boards[i][j].equals("O")) O++;
                else if (boards[i][j].equals("X")) X++;
                else etc++;
            }
        }
        
        // O가 X보다 많거나 같아야 함
        if (O < X) {
            return 0;
        }
        
        // O가 X보다 1만큼만 커야함
        if (O > X + 1) {
            return 0;
        }
        
        // 승리 조건 확인
        if (check(boards, "O") && check(boards, "X")) {
            // 둘 다 승리
            return 0;
        } else if (check(boards, "O")) {
            // O승리, O = X
            if (O == X) return 0;
        } else if (check(boards, "X")) {
            // X승리, 0 > X (1개)
            if (O == X + 1) return 0;
        }
        
        return 1; // 오류가 없다면
    }
    
    // 승리 조건을 체크하는 메소드
    public boolean check(String[][] board, String player) { // player = O or X
    for (int i = 0; i < 3; i++) {
        // 가로, 세로 확인
        if ((board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) ||
            (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))) {
            return true;
        }
    }
    // 대각선 확인
    if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
        (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) {
        return true;
        }
    return false;
    }
}
