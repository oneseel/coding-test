class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] matrix = new int[rows][columns];
        int number = 1;
        int[] answer = new int[queries.length];
        
        // 주어진 행렬에 기본값 넣기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = number++;
            }
        }
        
        // 각 쿼리에 대해 행렬 테두리 회전
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            // 시작점 저장
            int temp = matrix[x1][y1];
            int min = temp;
            
            // 왼쪽으로 이동
            for (int j = x1; j < x2; j++) {
                matrix[j][y1] = matrix[j + 1][y1];
                min = Math.min(min, matrix[j][y1]);
            }
            
            // 아래로 이동
            for (int j = y1; j < y2; j++) {
                matrix[x2][j] = matrix[x2][j + 1];
                min = Math.min(min, matrix[x2][j]);
            }
            
            // 오른쪽으로 이동
            for (int j = x2; j > x1; j--) {
                matrix[j][y2] = matrix[j - 1][y2];
                min = Math.min(min, matrix[j][y2]);
            }
            
            // 위로 이동
            for (int j = y2; j > y1; j--) {
                matrix[x1][j] = matrix[x1][j - 1];
                min = Math.min(min, matrix[x1][j]);
            }
            
            // 초기 시작점을 마지막에 빈 자리에 할당
            matrix[x1][y1 + 1] = temp;

            // 이동한 숫자 중 최소값을 배열에 저장
            answer[i] = min;
        }
        
        return answer;
    }
}