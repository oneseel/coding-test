import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int constructor = 0; // 생성자
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result = i + digitSum(i);
            if (result == n) {
                constructor = i;
                break;
            }
        }

        System.out.println(constructor);
    }

    // 각 자리수의 합을 구하는 메서드
    private static int digitSum (int i) {
        int num = 0;
        while (i > 0) {
            num += i % 10;
            i /= 10;
        }

        return num;
    }
}