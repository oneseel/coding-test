import java.util.*;

class Solution {
    private boolean[][] visited = new boolean[22][22];

    public int solution(String dirs) {
        String[] arr = dirs.split("");
        int[] current = new int[2];
        current[0] = 10;
        current[1] = 10;
        int x = current[0];
        int y = current[1];
        int distance = 0; // 거리


        for (String s : arr) {
            switch (s) {
                case "U":
                    y += 2;
                    if (0 <= x && x <= 20 && 0 <= y && y <= 20) {
                        if (!isVisit(x, y - 1)) {
                            distance++;
                        }
                    } else {
                        y -= 2;
                    }
                    break;
                case "D":
                    y -= 2;
                    if (0 <= x && x <= 20 && 0 <= y && y <= 20) {
                        if (!isVisit(x, y + 1)) {
                            distance++;
                        }
                    } else {
                        y += 2;
                    }
                    break;
                case "R":
                    x += 2;
                    if (0 <= x && x <= 20 && 0 <= y && y <= 20) {
                        if (!isVisit(x - 1, y)) {
                            distance++;
                        }
                    } else {
                        x -= 2;
                    }
                    break;
                case "L":
                    x -= 2;
                    if (0 <= x && x <= 20 && 0 <= y && y <= 20) {
                        if (!isVisit(x + 1, y)) {
                            distance++;
                        }
                    } else {
                        x += 2;
                    }
                    break;
            }
        }
        return distance;
    }

    private boolean isVisit(int x, int y) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            return false;
        }

        return true;
    }
}