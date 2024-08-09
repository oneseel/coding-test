import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 단
        int K = Integer.parseInt(st.nextToken()); // 항

        int max = 0;

        for (int i = 1; i <= K; i++) {
            String temp = String.valueOf(i * N);
            max = Math.max(max, reverse(temp));
        }

        System.out.println(max);
    }

    // 문자열 뒤집기
    private static int reverse(String temp) {
        StringBuilder sb = new StringBuilder(temp);
        String s = sb.reverse().toString();
        return Integer.parseInt(s);
    }
}