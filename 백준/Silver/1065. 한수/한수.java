import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0; // 한수의 개수
        
        if (n < 100) {
            count = n;
        } else {
            count = 99; // 1부터 99까지의 모든 수는 한수이다.
            if (n == 1000) { // 1000은 한수가 아니므로 999까지만 고려
                n = 999;
            }
            for (int i = 100; i <= n; i++) {
                int hundred = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;
                
                // 등차수열인지 확인
                if ((hundred - ten) == (ten - one)) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}
