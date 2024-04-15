import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine()); // 총 금액
        int N = Integer.parseInt(br.readLine()); // 물건의 종류
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken()); // 물건의 가격
            int count = Integer.parseInt(st.nextToken()); // 물건의 개수
            
            sum += price * count;
        }
        if (X == sum) System.out.println("Yes");
        else System.out.println("No");
    }
}