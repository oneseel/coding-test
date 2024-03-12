import java.util.*;

class Solution {
    // 상하좌우 이동을 위한 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] map;
    static boolean[][] visit;
    static int row;
    static int column;
    
    public int[] solution(String[] maps) {
        row = maps.length;
        column = maps[0].length();
        
        List<Integer> day = new ArrayList<>(); // 머무르는 기간을 저장할 리스트
        map = new String[row][column]; // 문자열을 2차원 배열로 변환
        visit = new boolean[row][column]; // 방문 여부를 체크
        
        // 문자열 배열을 2차원 배열로 변환
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
        }
        
        // 모든 맵을 순회
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                // 방문하지 않았고 바다가 아닌 경우
                if (!visit[i][j] && !"X".equals(map[i][j])) { 
                    // bfs를 이용해서 머무를 수 있는 기간 계산
                   int temp = bfs(i, j);
                    if (temp > 0) {
                        day.add(temp);
                    }
                }
            }
        }

        // 리스트가 비어있는 경우 -1
        if (day.isEmpty()) {
            day.add(-1);
        }

        // 리스트를 배열로 변환하고 오름차순 정렬
        int[] answer = day.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
    
    public int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
        queue.add(new int[]{i, j});
        visit[i][j] = true;
        int sum = Integer.parseInt(map[i][j]);
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            for(int k = 0; k < 4; k++) { // 상하좌우 탐색
                int nx = dx[k] + temp[0]; // 다음 x 위치
                int ny = dy[k] + temp[1]; // 다음 y 위치
                
                // 범위 내에 있고, 방문하지 않았으며, 바다가 아닌 경우
                if (nx >= 0 && nx < row && ny >=0 && ny < column && !visit[nx][ny] && !"X".equals(map[nx][ny])) {
                    queue.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    sum += Integer.parseInt(map[nx][ny]);
                }
            }
        }
        
        return sum;
    }
}
