import java.util.*;

class Solution {
    private static char[][] blocks; // 전체 블록 배열
    private static boolean[][] marked; // 삭제 예정 블록 배열 
    
    public int solution(int m, int n, String[] board) {
        blocks = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }
        
        int answer = 0;
        boolean isDeleted;
        
        do {
            marked = new boolean[m][n];
            isDeleted = false;
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    // 2 X 2배열이 0이 아닌 값으로 모두 같으면 마크해준다.
                    if (blocks[i][j] != '0' && checkBlock(i, j)) {
                        markBlock(i, j);
                        isDeleted = true;
                    }
                }
            }
            
            // 실제로 블록을 삭제('0')하고 위에 있는 블록을 떨어뜨린다.
            if (isDeleted) {
                answer += deleteBlocks(m, n);
                dropBlocks(m, n);
            }
            
        } while (isDeleted);
        
        return answer;
    }
    
    // 2 X 2 배열에 있는 값이 모든 같은 값인지 확인하는 메서드
    private static boolean checkBlock(int x, int y) {
        char block = blocks[x][y];
        return blocks[x + 1][y] == block && blocks[x][y + 1] == block && blocks[x + 1][y + 1] == block;
    }
    
    // 삭제할 블록을 마크해두는 메서드
    private static void markBlock(int x, int y) {
        marked[x][y] = true;
        marked[x + 1][y] = true;
        marked[x][y + 1] = true;
        marked[x + 1][y + 1] = true;
    }
    
    // 블록을 삭제하는 메서드 (삭제한 블록의 수를 센다)
    private int deleteBlocks(int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (marked[i][j]) {
                    blocks[i][j] = '0';
                    count++;
                }
            }
        }
        return count;
    }
    
    // 블록을 떨어뜨리는 메서드
    private void dropBlocks(int m, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (blocks[i][j] == '0') {
                    int k = i - 1;
                    while (k >= 0 && blocks[k][j] == '0') {
                        k--;
                    }
                    if (k >= 0) {
                        blocks[i][j] = blocks[k][j];
                        blocks[k][j] = '0';
                    }
                }
            }
        }
    }
}