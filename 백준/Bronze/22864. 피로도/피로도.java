import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 시간당 피로도 증가량
        int B = Integer.parseInt(st.nextToken()); // 시간당 처리한 일의 양
        int C = Integer.parseInt(st.nextToken()); // 시간당 줄어드는 피로도
        int M = Integer.parseInt(st.nextToken()); // 최대 피로도
        int t = 0; // 현재 시간
        int f = 0; // 현재 피로도
        int l = 0; // 현재 처리한 일의 양

        if (A > M) {
            System.out.println(0);
            return;
        }

        while (t < 24) {
            // 일을 할 수 있는 경우
            if (f + A <= M) {
                f += A;
                l += B;
            // 일을 할 수 없는 경우  
            } else {
                f -= C;
                if (f < 0) f = 0;
            }
            t++;
        }

        System.out.println(l);
    }
}
