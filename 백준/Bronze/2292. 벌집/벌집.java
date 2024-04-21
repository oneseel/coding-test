import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        int answer = 1; // 지나온 방 수 (1번째 방 포함하므로 1부터 시작)
        
        for (int i = 1; i < n; i++) {
            sum += 6 * i;
            if (n <= sum) {
                answer += i;
                break;
            }
        }
        System.out.println(answer);
    }
}