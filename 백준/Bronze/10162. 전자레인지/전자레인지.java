import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 필요한 요리 시간
        int A = 0; // 5분 = 300초
        int B = 0; // 1분 = 60초
        int C = 0; // 10초
        
        if (T % 10 != 0) {
            System.out.println(-1);
            return;
        }
       
        A = T / 300;
        T %= 300;
        B = T / 60;
        T %= 60;
        C = T / 10;
        
        System.out.println(A + " " + B + " " + C);
    }
}
