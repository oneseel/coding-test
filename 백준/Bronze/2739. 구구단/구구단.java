import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= 9; i++) {
            int result = N * i;
            System.out.println(N + " * " + i + " = " + result);
        }
    }
}