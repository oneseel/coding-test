import java.io.*;

class Main {
    private static char[][] star;

    public static void main(String[] args) throws IOException {
        
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 별의 세로 길이
        star = new char[n][n * 2 - 1]; // 별이 찍힐 배열

        // 배열을 공백으로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                star[i][j] = ' ';
            }
        }

        // 재귀적으로 별 그리기
        drawStar(0, n - 1, n);  // 별의 최상단 꼭지점의 위치는 (0, n - 1)이다.

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    // 별 그리기 메서드
    private static void drawStar(int x, int y, int h) {
        // 최소 삼각형의 길이는 3이다.
        if (h == 3) {
            star[x][y] = '*';
            star[x + 1][y - 1] = star[x + 1][y + 1] = '*';
            star[x + 2][y - 2] = star[x + 2][y - 1] = star[x + 2][y] = star[x + 2][y + 1] = star[x + 2][y + 2] = '*';
        } else {
            int half = h / 2;
            drawStar(x, y, half);
            drawStar(x + half, y - half, half);
            drawStar(x + half, y + half, half);
        }
    }
}
