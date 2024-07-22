import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        int n = Integer.parseInt(br.readLine()); // 문어의 수
        StringBuilder sb = new StringBuilder();

        // 2. 홀수라면 1, 짝수라면 2
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                sb.append(1).append(" ");
            } else {
                sb.append(2).append(" ");
            }
        }

        // 3. 마지막 값이 n이 홀수라면 3, 짝수라면 2
        if (n % 2 != 0) sb.append(3);
        else sb.append(2);

        System.out.println(sb.toString());
    }
}