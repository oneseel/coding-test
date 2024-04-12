import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int price = Integer.parseInt(br.readLine()); // 물건 가격
        int money = 1000 - price; // 거스름돈
        int count = 0; // 동전의 개수
        int[] type = {500, 100, 50, 10, 5, 1}; // 돈의 종류
        
        for (int i = 0; i < 6; i++) {
            count += money / type[i];
            money %= type[i];
        }
        
        System.out.println(count);
    }
}