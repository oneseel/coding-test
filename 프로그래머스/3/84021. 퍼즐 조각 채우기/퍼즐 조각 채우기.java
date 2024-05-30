import java.util.*;

class Solution {
    private static List<List<int[]>> shape1; // 테이블 모양
    private static List<List<int[]>> shape2; // 게임 보드 모양
    private static int n;

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length; // 정사각형의 길이
        boolean[][] visited1 = new boolean[n][n]; // table 방문 표시
        boolean[][] visited2 = new boolean[n][n]; // game_board 방문 표시
        shape1 = new ArrayList<>();
        shape2 = new ArrayList<>();

        // 테이블에서 모양 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && !visited1[i][j]) {
                    List<int[]> shape = new ArrayList<>();
                    bfs(i, j, table, visited1, 1, shape);
                    shape1.add(normalizeShape(shape));
                }
            }
        }

        // 게임보드에서 빈 모양 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !visited2[i][j]) {
                    List<int[]> shape = new ArrayList<>();
                    bfs(i, j, game_board, visited2, 0, shape);
                    shape2.add(normalizeShape(shape));
                }
            }
        }

        // 모양 비교
        int totalCount = 0;
        for (List<int[]> shape : shape2) {
            boolean found = false;
            for (int i = 0; i < shape1.size(); i++) {
                if (matchShape(shape, shape1.get(i))) {
                    totalCount += shape.size();
                    shape1.remove(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int i = 0; i < shape1.size(); i++) {
                    List<int[]> rotatedShape = shape;
                    for (int r = 0; r < 3; r++) { // 최대 3번 회전
                        rotatedShape = rotate(rotatedShape);
                        if (matchShape(rotatedShape, shape1.get(i))) {
                            totalCount += shape.size();
                            shape1.remove(i);
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
            }
        }
        
        return totalCount;
    }

    private static void bfs(int sx, int sy, int[][] maps, boolean[][] visited, int ox, List<int[]> shape) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        shape.add(new int[]{sx, sy});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny, maps, visited, ox)) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    shape.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean isValid(int nx, int ny, int[][] maps, boolean[][] visited, int ox) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n && maps[nx][ny] == ox && !visited[nx][ny];
    }

    // 모양 일치 여부
    private static boolean matchShape(List<int[]> shape1, List<int[]> shape2) {
        if (shape1.size() != shape2.size()) {
            return false;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int[] pos : shape1) {
            set1.add(pos[0] + "," + pos[1]);
        }
        for (int[] pos : shape2) {
            set2.add(pos[0] + "," + pos[1]);
        }
        return set1.equals(set2);
    }

    // 회전
    private static List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] pos : shape) {
            rotated.add(new int[]{pos[1], n - 1 - pos[0]});
        }
        return normalizeShape(rotated);
    }

    // 정규화
    private static List<int[]> normalizeShape(List<int[]> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] pos : shape) {
            minX = Math.min(minX, pos[0]);
            minY = Math.min(minY, pos[1]);
        }
        List<int[]> normalized = new ArrayList<>();
        for (int[] pos : shape) {
            normalized.add(new int[]{pos[0] - minX, pos[1] - minY});
        }
        return normalized;
    }
}
