import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 좌석 수
        String info = br.readLine(); // 좌석정보
        int cupholder = N + 1; // 전부 S일경우 컵홀더의 수
        int S = 0; // 일반좌석의 수
        int L = 0; // 커플좌석의 수
        
        for (int i = 0; i < N; i++) {
            if (info.charAt(i) == 'S') S++;
            else L++;
        }
        
        // 컵홀더가 사람 수보다 많은 경우도 생각해야한다.
        cupholder = Math.min(N, cupholder - L / 2);
        
        System.out.println(cupholder);
    }
}