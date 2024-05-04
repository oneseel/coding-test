import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int originalNum = n; // 처음 주어진 값
        int count = 0; // 사이클 횟수
        
        do {
            originalNum = ((originalNum % 10) * 10) + (((originalNum / 10) + (originalNum % 10)) % 10);
            count++; // 사이클 길이 증가
        } while (originalNum != n);
        
        System.out.println(count);
    }
}