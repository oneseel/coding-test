import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int money = Integer.parseInt(br.readLine()); // 거스름돈
            int quarter = money / 25;
            money %= 25;
            int dime = money / 10;
            money %= 10;
            int nickel = money / 5;
            money %= 5;
            int penny = money / 1;
            money %= 1;
            
            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
    }
}
