import java.util.*;

class Solution {
    private Stack<Integer> stack = new Stack<>();
    private int count = 0;

    public int solution(int[][] board, int[] moves) {

        // 인형 뽑기
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int doll = board[j][moves[i] - 1]; // 뽑을 인형
                if (doll != 0) {
                    bomb(doll);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return count;
    }

    // 바구니에 담기
    private void bomb(int doll) {
        if (!stack.isEmpty() && stack.peek() == doll) {
            stack.pop();
            count += 2;
        } else {
            stack.push(doll);
        }
    }
}