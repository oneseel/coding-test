import java.util.*;

public class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        
        for (int i = 0; i < places.length; i++) {
            // 각 대기실별 사람들의 위치를 저장
            List<Position> participants = new ArrayList<>();
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        participants.add(new Position(j, k));
                    }
                }
            }
            
            // 각 사람별로 BFS를 통해 거리두기 준수 여부 확인
            for (Position participant : participants) {
                if (!bfs(participant, places[i])) {
                    answer[i] = 0;
                    break;
                }
            }
        }
    
        return answer;
    }
    
    private boolean bfs(Position start, String[] place) {
        int[] dx = {1, -1, 0, 0}; 
        int[] dy = {0, 0, 1, -1};
        
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.offer(new Position(start.x, start.y, 0));
        visited[start.x][start.y] = true;
        
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            
            if (current.dist > 2) continue; // 맨해튼 거리가 2 초과시 더 이상 탐색하지 않음
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                    if (place[nx].charAt(ny) == 'O') {
                        queue.offer(new Position(nx, ny, current.dist + 1));
                        visited[nx][ny] = true;
                    } else if (place[nx].charAt(ny) == 'P' && current.dist + 1 <= 2) {
                        return false; // 규칙 위반
                    }
                }
            }
        }
        
        return true; // 규칙 준수
    }
    
    class Position {
        int x, y, dist;
        
        Position(int x, int y) {
            this(x, y, 0);
        }
        
        Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
