import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0; // 최대 탑승자수
        int sum = 0; // 현재 탑승자수

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            sum -= out;
            sum += in;
            if (max < sum) max = sum;
        }
        System.out.println(max);
    }
}