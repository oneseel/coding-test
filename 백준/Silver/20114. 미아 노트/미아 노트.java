import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 원래 문자열의 길이
        int h = Integer.parseInt(st.nextToken()); // 세로로 번진 길이
        int w = Integer.parseInt(st.nextToken()); // 가로로 번진 길이
        char[][] arr = new char[h][n * w];

        for (int i = 0; i < h; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n * w; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        // 각 문자 블록을 순회
        for (int i = 0; i < n; i++) {
            int start = i * w;
            char foundChar = '?';

            // 블록을 순회하며 '?'가 아닌 문자를 찾는다.
            outerLoop:
            for (int j = 0; j < h; j++) {
                for (int k = start; k < start + w; k++) {
                    if (arr[j][k] != '?') {
                        foundChar = arr[j][k];
                        break outerLoop;
                    }
                }
            }

            sb.append(foundChar);
        }

        System.out.println(sb.toString());
    }
}
