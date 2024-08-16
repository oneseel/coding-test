import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 동아리방의 개수
        int M = Integer.parseInt(br.readLine()); // 행동 횟수

        boolean[] wall = new boolean[N - 1];
        Arrays.fill(wall, true);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for (int j = x; j < y; j++) {
                wall[j] = false;
            }
        }

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            if (wall[i]) {
                count++;
            }
        }

        System.out.println(count + 1);
    }
}