import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 개수

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 오셀로 말의 개수
            String start = br.readLine(); // 초기상태
            String goal = br.readLine(); // 목표상태

            int black = 0;
            int white = 0;

            for (int i = 0; i < N; i++) {
                // 오셀로 말이 같을 경우 넘어간다.
                if (start.charAt(i) == goal.charAt(i)) {
                    continue;

                    // 오셀로 말이 다를 경우
                } else {
                    if (start.charAt(i) == 'B') {
                        black++;
                    } else {
                        white++;
                    }
                }
            }

            int count = Math.max(black, white);
            System.out.println(count);
        }
    }
}