class Solution {
    static int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        division(0, 0, arr.length, arr);
        
        return answer;
    }
    // 분할
    private void division (int x, int y, int size, int[][] arr) {
        if (compression(x, y, size, arr)) {
            answer[arr[x][y]]++;
            return;
        }
        // 1번 영역
        division(x, y, size / 2, arr);
        // 2번 영역
        division(x + size / 2, y, size / 2, arr);
        // 3번 영역
        division(x, y + size / 2, size / 2, arr);
        // 4번 영역
        division(x + size / 2, y + size / 2, size / 2, arr);
    }

    
    // 영역에 있는 값이 모두 같은지를 확인
    private boolean compression (int x, int y, int size, int[][] arr) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}