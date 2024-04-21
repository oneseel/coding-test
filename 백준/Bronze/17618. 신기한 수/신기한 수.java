import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(countAmazingNumbers(n));
    }
    
    private static int countAmazingNumbers(int n) {
        // 10 이하의 수는 신기한 수이다.
        if (n <= 10) return n;
        
        int count = 10; // 신기한 수의 개수
        
        for (int i = 11; i <= n; i++) {
            int temp = i;
            int sum = 0; // 자리수에 있는 수들을 합친 값
            
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            
            // 약수라면 카운트 증가
            if (i % sum == 0) {
                count++;
            }
        }
        return count;
    }
}
