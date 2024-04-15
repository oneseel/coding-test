import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 4; i <= N; i += 4) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}