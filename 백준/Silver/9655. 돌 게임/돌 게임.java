import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 돌의 개수
        
        int temp = n % 4;
        
        if (temp == 1 || temp == 3) System.out.println("SK");
        else System.out.println("CY");
    }
}